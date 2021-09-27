package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
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

    private static final String baseDescriptFolder = "README";
    private static final String baseDataFolder = "data";
    private static Date currentDate;

    public static String openedFilePath;

    public static boolean needSaveState = false;

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

            String name = Inputter.getString("Enter Name: ", true, true).trim().replace(" +", " ").toUpperCase();
            Double weight = Inputter.getDoubleWithCondition("Weight (0 < w <= 100): ", true, new Predicate<Double>() {

                @Override
                public boolean test(Double t) {
                    if (t > 0 && t <= 100) {
                        return true;
                    } else {
                        System.out.println(TextColor.create(">> The weight must be in (0..100]", Color.YELLOW));
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
                    String input = Inputter.getStringWithPattern("Expired Date (dd/MM/yyyy): ", true,
                            "\\d{1,2}/\\d{1,2}/\\d{1,4}");
                    expiredDate = dateFormat.parse(input);

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
            needSaveState = true;
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

        if(list.size() > 0){

        
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
        }else{
            System.out.println(TextColor.create(">> This food does not exist!", Color.YELLOW));
        }
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
        } else if (toDate.getTime() - currentDate.getTime() < 0) {
            return TextColor.create("expired", Color.RED);
        } else {
            return TextColor.create("today", Color.YELLOW);
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
                                needSaveState = true;
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
            if(foodList.size() > 0){
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
            }else{
                System.out.println(TextColor.create(">> There is no food to print", Color.YELLOW));
                pause();
                break;
            }
            

        } while (Inputter.askYN("Do you want to continue? (Y/N): "));

    }

    // public static void searchFoodByWeight(){
    //     do{
    //         clearScreen();
    //         System.out.println("SEARCH BY WEIGHT");
    //         if(foodList.size() > 0){
    //         double inputWeight = Inputter.getDoubleWithCondition("Input weight: ", true, new Predicate<Double>(){

    //             @Override
    //             public boolean test(Double t) {
    //                 if(t <= 0 || t > 100){
    //                     System.out.println("Input must be in range (0..100]");
    //                     return false;
    //                 }
    //                 return true;
    //             }
                
    //         });

    //         showFood(foodList.searchByWeight(inputWeight));
    //     }else{
    //         System.out.println(TextColor.create(">> There is no food to search", Color.YELLOW));
    //     }
    //     }while(Inputter.askYN("Do you want to continue? (Y/N): "));
    // }

    public static void saveToFile() {

        clearScreen();
        printREADME("save.txt");
        if(foodList.size() > 0){
            if (openedFilePath != null) {
                System.out.println("Current opened file: " + TextColor.create(openedFilePath, Color.PURPLE) + "\n");
                if(needSaveState){
                    int choice = Inputter.getIntWithCondition(
                        "[1]. You want to save to current file?\n[2]. You want to save to new file?\nYour choice: ", true,
                        new Predicate<Integer>() {
    
                            @Override
                            public boolean test(Integer t) {
                                if (t != 1 && t != 2) {
                                    System.out.println(TextColor.create("\nValue must be 1 or 2\n", Color.YELLOW));
                                    return false;
                                }
                                return true;
                            }
    
                        });
    
                if (choice == 1) {
                    if (foodList.saveToFile(baseDataFolder + "/" + openedFilePath)) {
                        System.out.println(TextColor.create("\n>> SAVED SUCCESSFULLY\n", Color.GREEN));
                    } else {
                        System.out.println(TextColor.create("\n>> SAVED FAILED\n", Color.RED));
                    }
                    needSaveState = false;
                } else {
                    String inputFileName;
                    do{
                        inputFileName = Inputter.getString("Input file name to create: ", true, true).trim() + ".dat";
                        File file = new File(baseDataFolder + "/" + inputFileName);
                        if(file.exists()){
                            System.out.println(TextColor.create(">> The file is already existed!", Color.YELLOW));
                        }else break;
                    }while(true);
                    if (foodList.saveToFile(baseDataFolder + "/" + inputFileName)) {
                        System.out.println(TextColor.create("\n>> SAVED SUCCESSFULLY\n", Color.GREEN));
                    } else {
                        System.out.println(TextColor.create("\n>> SAVED FAILED\n", Color.RED));
                    }
                }
                }else{
                    System.out.println("There's no change to save!");
                }
                
            } else {
                System.out.println("There is no file open!");
                String inputFileName;
                do{
                    inputFileName  = Inputter.getString("Input file name to create: ", true, true).trim() + ".dat";
                    File file = new File(baseDataFolder + "/" + inputFileName);
                    if(file.exists()){
                        System.out.println(TextColor.create(">> The file is already existed!", Color.YELLOW));
                    }else break;
                }while(true);
                if (foodList.saveToFile(baseDataFolder + "/" + inputFileName)) {
                    System.out.println(TextColor.create("\n>> SAVED SUCCESSFULLY\n", Color.GREEN));
                    openedFilePath = inputFileName;
                    needSaveState = false;
                } else {
                    System.out.println(TextColor.create("\n>> SAVED FAILED\n", Color.RED));
                }
            }
            
        }else{
            System.out.println(TextColor.create("There is no data to save!", Color.YELLOW));
        }
        pause();
    }

    // public static void loadFromFile() {

    // clearScreen();
    // printREADME("load.txt");
    // String filePath = Inputter.getString("Input file path: ", true, true);
    // foodList.loadFromFile(filePath);
    // pause();
    // }

    /////// UI DRAWING
    public static void printREADME(String filename) {
        String path = baseDescriptFolder + "/" + filename;

        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(TextColor.create(">> File not found", Color.RED));
        }
    }

    public static void pause() {
        // pause
        Inputter.getString("", false, false);
    }

    public static void openFile() {

        clearScreen();
        printREADME("open.txt");
        String filename = Inputter.getString("Input file name: ", true, true).trim().replace(" ", "") + ".dat";
        File file = new File(baseDataFolder + "/" + filename);

        if (file.exists() && !file.isDirectory()) {
            try {
                if (openedFilePath != null) {
                    if(needSaveState){
                        if (Inputter.askYN("Do you want to save current file before opening new file? (Y/N): ")) {
                            if (foodList.saveToFile(baseDataFolder + "/" + openedFilePath)) {
                                System.out.println(
                                        TextColor.create(">> SAVED " + openedFilePath + " SUCCESSFULLY", Color.GREEN));
                            } else {
                                System.out.println(TextColor.create(">> SAVED " + openedFilePath + " FAILED", Color.RED));
                            }
                        } else {
                            System.out.println(TextColor.create(">> UNSAVED " + openedFilePath, Color.YELLOW));
                        }
                        
                    }
                }else{
                    if(needSaveState){
                        if(Inputter.askYN("Do you want to create a file for your data before opening new file? (Y/N): ")){
                            String createdFilename;
                            do{
                                createdFilename = Inputter.getString("Input file name to create: ", true, true).trim().replace(" ", "")
                                + ".dat";
                                File newedFile = new File(baseDataFolder + "/" + createdFilename) ;
                                if(newedFile.exists()){
                                    System.out.println(TextColor.create(">> The file is already existed!", Color.YELLOW));
                                }
                                else break;
                            }while(true);
                            if (foodList.saveToFile(baseDataFolder + "/" + createdFilename)) {
                                System.out.println(TextColor.create(">> SAVED " + createdFilename + " SUCCESSFULLY", Color.GREEN));
                            } else {
                                System.out.println(TextColor.create(">> SAVED " + createdFilename + " FAILED", Color.RED));
                            }
                        }else{
                            System.out.println(TextColor.create(">> UNSAVED", Color.YELLOW));
                        }
                    }
                }
                
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                FoodList tmp = (FoodList) ois.readObject();
                foodList.clear();
                foodList.addAll(tmp);
                openedFilePath = filename;
                ois.close();
                needSaveState = false;
                System.out.println(TextColor.create(">> FILE " + filename + " IS OPENED", Color.GREEN));

            } catch (Exception e) {
                System.out.println(TextColor.create(">> An error occured, please try again!", Color.RED));
            }

        } else {
            System.out.println(TextColor.create("\n>> File not found!", Color.YELLOW));
        }
        System.out.println("\nPress Enter to come back!\n");
        pause();
    }

    public static void quitProgram() {
        if (foodList.size() > 0) {
            if(needSaveState){
                if (Inputter.askYN("Do you want to save before quitting? (Y/N): ")) {
                    if (openedFilePath != null) {
                        if (foodList.saveToFile(baseDataFolder + "/" + openedFilePath)) {
                            System.out
                                    .println(TextColor.create(">> SAVED " + openedFilePath + " SUCCESSFULLY", Color.GREEN));
                        } else {
                            System.out.println(TextColor.create(">> SAVED " + openedFilePath + " FAILED", Color.RED));
                        }
                    } else {
                        String filename;
                        do{
                            filename = Inputter.getString("Input file name to create: ", true, true).trim().replace(" ", "")
                            + ".dat";
                            File newedFile = new File(baseDataFolder + "/" + filename) ;
                            if(newedFile.exists()){
                                System.out.println(TextColor.create(">> The file is already existed!", Color.YELLOW));
                            }
                            else break;
                        }while(true);
                        
                        if (foodList.saveToFile(baseDataFolder + "/" + filename)) {
                            System.out.println(TextColor.create(">> SAVED " + filename + " SUCCESSFULLY", Color.GREEN));
                        } else {
                            System.out.println(TextColor.create(">> SAVED " + filename + " FAILED", Color.RED));
                        }
                    }
                }
            }
        }

        System.exit(0);
    }
}
