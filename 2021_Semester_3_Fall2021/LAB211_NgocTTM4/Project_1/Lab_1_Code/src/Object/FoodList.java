package Object;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FoodList extends Vector<Food> {

    transient Scanner sc;

    public FoodList() {
        sc = new Scanner(System.in);
    }

    public FoodList(FoodList foodList) {
        this.addAll(foodList);
    }

    public Food search(String id) {
        for (Food food : this) {
            if (food.getId().equals(id)) {
                return food;
            }
        }
        return null;
    }

    // public FoodList searchByWeight(double weight){
    //     FoodList ret = new FoodList();
    //     for(Food food: this){
    //         if(weight == food.getWeight())
    //             ret.add(food);
    //     }
    //     return ret;
    // }

    public FoodList searchByName(String name) {
        FoodList ret = new FoodList();
        for (Food food : this) {
            String pattern = name.trim().toUpperCase().replaceAll(" ", ".*");

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(food.getName());
            if (m.find()) {
                ret.add(food);
            }
        }
        return ret;
    }

    // public boolean searchByName(String name){
    // for (Food food : this) {
    // if(food.getName() == name)
    // return true;
    // }
    // return false;
    // }

    // Sort by
    public FoodList sortBy(int by, boolean isAscending) {
        FoodList tmp = new FoodList(this);

        tmp.sort(new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                int addition = 1;
                if (!isAscending)
                    addition = -1;
                switch (by) {
                    case 1: // by id
                        return o1.getId().compareTo(o2.getId()) * addition;
                    case 2: // by name
                        return o1.getName().compareTo(o2.getName()) * addition;
                    case 3: // by weight
                    {
                        if (o1.getWeight() < o2.getWeight())
                            return -1 * addition;
                        else if (o1.getWeight() > o2.getWeight())
                            return 1 * addition;
                        else
                            return 0;

                    }
                    case 4: // by type
                        return o1.getType().compareTo(o2.getType()) * addition;
                    case 5: // by expired date
                        return o1.getExpiredDate().compareTo(o2.getExpiredDate()) * addition;
                }
                return 0;
            }

        });
        return tmp;
    }

    public void remove(String id) {
        this.remove(id);
    }

    public void show() {
        for (Food f : this) {
            System.out.println(f);
        }
    }

    public boolean saveToFile(String fileNamePath) {
        try {
            File file = new File(fileNamePath);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    // public <T> void loadFromFile(String fileNamePath) {

    //     try {
    //         File file = new File(fileNamePath);
    //         FileInputStream fis = new FileInputStream(file);
    //         ObjectInputStream ois = new ObjectInputStream(fis);

    //         FoodList loadedFoodList = (FoodList) ois.readObject();

    //         boolean yesAllOption = false;
    //         boolean noAllOption = false;
    //         ois.close();

    //         Set<String> setId = this.stream().map(x -> x.getId()).collect(Collectors.toSet());

    //         Set<String> duplicatedId = loadedFoodList.stream().map(x -> x.getId()).filter(x -> setId.contains(x))
    //                 .collect(Collectors.toSet());

    //         for (Food f1 : loadedFoodList) {
    //             if (duplicatedId.contains(f1.getId())) {
    //                 Food tmp = this.search(f1.getId());
    //                 if (!yesAllOption && !noAllOption) {
    //                     FoodList tmpList = new FoodList();
    //                     tmpList.add(oldNewShower(f1, true));
    //                     tmpList.add(oldNewShower(tmp, false));
    //                     FunctionUI.showFood(tmpList);
    //                     int choice = Inputter.getIntWithCondition(
    //                             "There are two duplicate ID <" + f1.getId()
    //                                     + ">, do you want to overwrite? [1]: Yes, [2]: No, [3]: Yes All, [4]: No All: ",
    //                             true, new Predicate<Integer>() {

    //                                 @Override
    //                                 public boolean test(Integer t) {
    //                                     if (t >= 1 && t <= 4) {
    //                                         return true;
    //                                     } else {
    //                                         System.out.println("The value must be in range [1,4]");
    //                                         return false;
    //                                     }
    //                                 }
    //                             });

    //                     switch (choice) {
    //                         case 1:
    //                             // tmp = f1;
    //                             tmp.setId(f1.getId());
    //                             tmp.setName(f1.getName());
    //                             tmp.setPlace(f1.getPlace());
    //                             tmp.setType(f1.getType());
    //                             tmp.setWeight(f1.getWeight());
    //                             tmp.setExpiredDate(f1.getExpiredDate());
    //                             break;
    //                         case 2:
    //                             break;
    //                         case 3:
    //                             yesAllOption = true;
    //                             break;
    //                         case 4:
    //                             noAllOption = true;
    //                             break;
    //                     }
    //                 }
    //                 if (yesAllOption) {
    //                     // tmp = f1;
    //                     tmp.setId(f1.getId());
    //                     tmp.setName(f1.getName());
    //                     tmp.setPlace(f1.getPlace());
    //                     tmp.setType(f1.getType());
    //                     tmp.setWeight(f1.getWeight());
    //                     tmp.setExpiredDate(f1.getExpiredDate());
    //                 }
    //             } else {
    //                 this.add(f1);
    //             }
    //         }
    //         System.out.println(TextColor.create("\n>>LOADED SUCCESSFULLY!\n", Color.GREEN));
    //     } catch (Exception e) {
    //         System.out.println(TextColor.create("\nError occured, maybe the file is missing or something", Color.RED));
    //     }

    // }

    // private Food oldNewShower(Food food, boolean isNew) {
    //     Food tmp;
    //     if (isNew) {
    //         tmp = new Food(TextColor.create(food.getId() + " (new)", Color.GREEN), food.getName(), food.getWeight(),
    //                 food.getType(), food.getPlace(), food.getExpiredDate());

    //     } else {
    //         tmp = new Food(TextColor.create(food.getId() + " (old)", Color.RED), food.getName(), food.getWeight(),
    //                 food.getType(), food.getPlace(), food.getExpiredDate());
    //     }

    //     return tmp;
    // }
}
