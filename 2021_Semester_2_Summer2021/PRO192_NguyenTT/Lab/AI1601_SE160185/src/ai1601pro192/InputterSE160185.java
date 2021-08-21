package ai1601pro192;

import java.util.Scanner;
import java.util.function.Predicate;

public class InputterSE160185 {

    private static String errorString = "There's an error, please try again!";

    private static Scanner sc = new Scanner(System.in);

    public static Integer getInt(String message, boolean repeatedIfValid){
        do{
            try{
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                return value;
            }catch(Exception ex){
                System.out.println(errorString);
            }
        }while(repeatedIfValid);
        return null;
    }
    
    public static Double getDoubleWithCondition(String message, boolean repeatedIfValid, Predicate<Double> condition){
        do{
            try{
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine());
                if(condition.test(value)){
                    return value;
                }
            }catch(Exception ex){
                System.out.println(errorString);
            }
        }while(repeatedIfValid);
        return null;
    }

    public static Integer getIntWithCondition(String message, boolean repeatedIfValid, Predicate<Integer> condition){
        do{
            try{
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                if(condition.test(value)){
                    return value;
                }
            }catch(Exception ex){
                System.out.println(errorString);
            }
        }while(repeatedIfValid);
        return null;
    }

    public static String getString(String message, boolean repeatedIfValid, boolean notBlankStr){
        do{
            System.out.print(message);
            String value = sc.nextLine();
            if(notBlankStr){
                if(!value.isBlank()){
                    return value;
                }else{
                    System.out.println("String can't be blank!");
                }
            }else{
                return value;
            }
        }while(repeatedIfValid);
        return null;
    }

    public static String getStringWithPattern(String message, boolean repeatedIfValid, String pattern){
        do{
            System.out.print(message);
            String value = sc.nextLine();
            if(value.matches(pattern)){
                return value;
            }else{
                System.out.println("String doesn't match pattern");
            }
        }while(repeatedIfValid);
        return null;
    }
}
