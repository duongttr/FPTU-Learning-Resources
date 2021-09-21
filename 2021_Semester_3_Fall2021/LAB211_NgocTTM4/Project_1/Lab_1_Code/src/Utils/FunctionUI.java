package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;

import Object.Food;
import Object.FoodList;

/* Function idea:
    - Sort by name, type, id,... (ask user if they want to overwrite the sorting list to db)
    - when typing, show suggestion... :)
    - 
*/
public class FunctionUI {

    private static FoodList foodList = new FoodList();
    private static DateFormat dateFormat;

    private static final String baseFolder = "README";
    private static Date currentDate;

    static {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        currentDate = c.getTime();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void addFood() {
        do {
            clearScreen();
            printREADME("add.txt");
            System.out.println(TextColor.create("FOOD COUNT: " + foodList.size(), Color.BLUE) + "\n");
            String id;
            boolean isDuplicated;
            do {
                id = Inputter.getString("Enter ID: ", true, true).trim().toUpperCase();
                isDuplicated = foodList.search(id) != null;
                if (isDuplicated) {
                    System.out.println(TextColor.create(">> ID " + id + " is duplicated", Color.YELLOW));
                }
                ;
            } while (isDuplicated);

            String name = Inputter.getString("Enter Name: ", true, true).toUpperCase();
            Double weight = Inputter.getDoubleWithCondition("Weight (0 < w <= 100): ", true, new Predicate<Double>() {

                @Override
                public boolean test(Double t) {
                    if (t > 0 && t <= 100) {
                        return true;
                    } else {
                        System.out.println(TextColor.create(">> The weight must be in [1..100]", Color.YELLOW));
                    }
                    return (t > 0) && (t <= 100);
                }

            });
            String type = Inputter.getString("Enter Type: ", true, true).toUpperCase();
            int place;

            place = Inputter.getIntWithCondition("Place [0]-FREEZE, [1]-COOL, [2]-DOOR: ", true,
                    new Predicate<Integer>() {

                        @Override
                        public boolean test(Integer t) {
                            if (t > 2 || t < 0) {
                                System.out.println(TextColor.create(">> Place id must be in [0,1,2]", Color.YELLOW));
                                return false;
                            }
                            return true;
                        }

                    });

            Date expiredDate;

            // System.out.println(dateFormat.format(currentDate));
            while (true) {
                try {
                    expiredDate = dateFormat.parse(Inputter.getString("Expired Date (dd/MM/yyyy): ", true, true));

                    if (expiredDate.compareTo(currentDate) < 0) {
                        System.out.println(TextColor.create(">> You type the date in the past", Color.YELLOW));
                    } else
                        break;

                } catch (ParseException e) {
                    System.out.println(TextColor.create(">> Invalid date format!", Color.RED));
                }
            }

            foodList.add(new Food(id, name, weight, type, place, expiredDate));
            System.out.println(TextColor.create("\n>>ADDED SUCCESSFULLY\n", Color.GREEN));
        } while (Inputter.askYN("Do you want to continue? (Y/N): "));

    }

    public static void searchFoodByName() {
        do {
            clearScreen();
            printREADME("search.txt");
            if (foodList.size() > 0) {
                String text = Inputter.getString("Searching food by name: ", true, true);
                showFood(foodList.searchByName(text));
            } else {
                System.out.println(TextColor.create(">> There is no food to search", Color.YELLOW));
                System.out.print("\nPress Enter to go back!");
                pause();
                break;
            }

        } while (Inputter.askYN("Do you want to continue? (Y/N): "));

    }

    public static void showFood(FoodList list) {
        // clearScreen();

        System.out.println(
                "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println(
                "┃    ID    │            NAME            │    WEIGHT     │     TYPE      │   PLACE   │              EXP              ┃");
        System.out.println(
                "┃───────────────────────────────────────────────────────────────────────────────────────────────────────────────────┃");
        for (Food food : list) {
            System.out.println(String.format("┃%-10s│%-28s│%-15s│%-15s│%-11s│%-40s┃", food.getId(), food.getName(),
                    String.format("%.2f kgs", food.getWeight()), food.getType(), food.getPlaceText(),
                    dateFormat.format(food.getExpiredDate()) + " (" + calculateDuration(food.getExpiredDate()) + ")"));
        }
        System.out.println(
                "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println(TextColor.create("RESULT COUNT: " + list.size(), Color.BLUE) + "\n");
    }

    public static String calculateDuration(Date toDate) {
        long daysCount = (toDate.getTime() - currentDate.getTime()) / (1000 * 60 * 60 * 24);
        String ret = "";
        if (daysCount > 0) {
            if (daysCount >= 365) {
                long year = daysCount / 365;
                ret += " " + year + " yr";
                if (year > 1)
                    ret += "s";
                daysCount -= (year * 365);
            }
            if (daysCount >= 30) {
                long month = daysCount / 30;
                ret += " " + month + " mo";
                if (month > 1)
                    ret += "s";
                daysCount -= (month * 30);
            }
            if (daysCount > 0) {
                ret += " " + daysCount + " d";
                if (daysCount > 1)
                    ret += "s";
            }
        } else if (daysCount == 0) {
            return TextColor.create("today", Color.YELLOW);
        } else {
            return TextColor.create("expired", Color.RED);
        }
        return TextColor.create(ret.trim().replace(" +", " "), Color.GREEN);
    }

    public static void removeFood() {
        do {
            clearScreen();
            printREADME("remove.txt");
            if (foodList.size() > 0) {
                System.out.println(TextColor.create("FOOD COUNT: " + foodList.size(), Color.BLUE) + "\n");
                String id = Inputter.getString("Type id: ", true, true);
                group: {
                    for (Food food : foodList) {
                        if (food.getId().equals(id.toUpperCase())) {
                            FoodList tmp = new FoodList();
                            tmp.add(food);
                            showFood(tmp);
                            if (Inputter.askYN("Do you want to delete the food with id <" + food.getId().toUpperCase()
                                    + ">? (Y/N): ")) {
                                foodList.remove(food);
                                System.out.println(TextColor.create("\n>>REMOVED SUCCESSFULLY!\n", Color.GREEN));

                            }
                            break group;
                        }
                    }

                    System.out.println(
                            TextColor.create(">> There is no food with id <" + id.toUpperCase() + ">", Color.YELLOW));
                }
            } else {

                System.out.println(TextColor.create(">> There is no food to remove!", Color.YELLOW));
                System.out.print("\nPress Enter to go back!");
                pause();
                break;
            }

        } while (Inputter.askYN("Do you want to continue? (Y/N): "));

    }

    public static void printFoodWithOption() {
        do {
            clearScreen();
            printREADME("print.txt");
            int choiceFeild = Inputter.getIntWithCondition("Choose your option: ", true, new Predicate<Integer>() {

                @Override
                public boolean test(Integer t) {
                    if (t >= 0 && t <= 5) {
                        return true;
                    } else {
                        System.out.println(TextColor.create("The value must be in range [1,3]", Color.YELLOW));
                        return false;
                    }
                }
            });

            if (choiceFeild != 0) {
                int typeSort = Inputter.getIntWithCondition("Choose type of sorting ([0] - ASC, [1] - DESC): ", true,
                        new Predicate<Integer>() {

                            @Override
                            public boolean test(Integer t) {
                                if (t == 0 || t == 1) {
                                    return true;
                                } else {
                                    System.out.println(TextColor.create("The value must be 0 or 1", Color.YELLOW));
                                    return false;
                                }

                            }

                        });
                FoodList newedFoodList = foodList.sortBy(choiceFeild, typeSort == 0);

                showFood(newedFoodList);
            } else {
                showFood(foodList);
            }

        } while (Inputter.askYN("Do you want to continue? (Y/N): "));

    }

    public static void saveToFile() {

        clearScreen();
        printREADME("save.txt");
        String filePath = Inputter.getString("Input file path: ", true, true);
        foodList.saveToFile(filePath);
        pause();
    }

    public static void loadFromFile() {

        clearScreen();
        printREADME("load.txt");
        String filePath = Inputter.getString("Input file path: ", true, true);
        foodList.loadFromFile(filePath);
        pause();
    }

    /////// UI DRAWING
    public static void printREADME(String filename) {
        String path = baseFolder + "/" + filename;

        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(TextColor.create("File not found", Color.RED));
        }
    }

    public static void pause() {
        // pause
        Inputter.getString("", false, false);
    }
}
