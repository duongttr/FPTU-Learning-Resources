package employees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class EmployeeList extends Vector<Employee> {

    Scanner sc = new Scanner(System.in);
    public EmployeeList(){
        super();
    }


    /* Load data into EmployeeList from data.txt */
    public void loadDataFromFile(String fileName){
        try{
            File f = new File(fileName);
            if(!f.exists()) return;
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String data;
            while((data = bf.readLine()) != null){
                // Split data due to pattern E00,Name,Salary (comma seperated)
                StringTokenizer stk = new StringTokenizer(data, ",");

                // Retrieve data
                String code = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                int salary = Integer.parseInt(stk.nextToken());
                add(new Employee(code, name, salary));
            }
            bf.close();
            fr.close();
        }catch(Exception ex){
                System.out.println(ex);
        }
    }

    /* Save Data to file */
    public void save(String fileName){
        if(size() == 0){ // If there's no data in list
            System.out.println("Empty list!");
        }else{
            try{
                File f = new File(fileName);
                FileWriter fw = new FileWriter(f);
                BufferedWriter pw = new BufferedWriter(fw);
                for(Employee e: this){
                    // Write data into file
                    pw.write(
                        e.getCode() + "," +
                        e.getName() + "," +
                        e.getSalary()
                    );
                    pw.write("\n");
                }
                pw.close(); fw.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public void addEmployee(){ 

        System.out.println(
            "   ___      _     _   _____                _                       \n" +
            "  / _ \\    | |   | | |  ___|              | |                      \n" +
            " / /_\\ \\ __| | __| | | |__ _ __ ___  _ __ | | ___  _   _  ___  ___ \n" +
            " |  _  |/ _` |/ _` | |  __| '_ ` _ \\| '_ \\| |/ _ \\| | | |/ _ \\/ _ \\\n" +
            " | | | | (_| | (_| | | |__| | | | | | |_) | | (_) | |_| |  __/  __/\n" +
            " \\_| |_/\\__,_|\\__,_| \\____/_| |_| |_| .__/|_|\\___/ \\__, |\\___|\\___|\n" +
            "                                    | |             __/ |          \n" +
            "                                    |_|            |___/           ");
        System.out.println("Instructions: ");
        System.out.println("- The [CODE] must be match the pattern (E _ _ _) - starts with letter E and 3 digits");
        System.out.println("- The [NAME] must not be empty!");
        System.out.println("- The [SALARY] must not be lower than 0!");
        System.out.println(Utils.printChar('═', 100));
        String newCode, newName;
        int newSalary;
        do{
            do{
                System.out.print("CODE (E000): "); newCode = sc.nextLine().toUpperCase();
                if(newCode.matches("^E\\d{3}$")){ // If input code matches "E000"
                    int pos = find(newCode); // Find the position of that employee
                    if(pos != -1){ // If that employee is existed
                        Utils.showTextAndRetype("This CODE is already existed!");
                    }else{
                        break;
                    }
                }else{ // Show warning and retype
                    Utils.showTextAndRetype("This CODE is not valid!");
                }
            }while(true);
    
            do{
                System.out.print("NAME: "); newName = sc.nextLine().toUpperCase();
                if(!newName.isEmpty()){ // If inputed name is not empty
                    break;
                }else{ // Retype
                    Utils.eraseLine(1);
                }
            }while(true);
    
            do{
                System.out.print("SALARY: "); 
                try{
                    newSalary = Integer.parseInt(sc.nextLine());
                    if(newSalary < 0){ // If inputed salary is lower than zero
                        Utils.eraseLine(1);
                    }else{
                        break;
                    }
                    
                }catch(Exception e){
                    Utils.eraseLine(1);
                }
            }while(true);
    
            // Add data to List
            add(new Employee(
                newCode,
                newName,
                newSalary
            ));
            
        }while(Utils.wantToContinue()); // Check if user want to continue?
    }
    
    /* Remove the employee out of list */
    public void removeEmployee(){
        System.out.println(
            "______                                     _____                   _                                       \n" +
            "| ___ \\                                   |  ___|                 | |                                      \n"+
            "| |_/ / ___  _ __ ___    ___ __   __ ___  | |__  _ __ ___   _ __  | |  ___   _   _   ___   ___             \n"+
            "|    / / _ \\| '_ ` _ \\  / _ \\\\ \\ / // _ \\ |  __|| '_ ` _ \\ | '_ \\ | | / _ \\ | | | | / _ \\ / _ \\            \n"+
            "| |\\ \\|  __/| | | | | || (_) |\\ V /|  __/ | |___| | | | | || |_) || || (_) || |_| ||  __/|  __/            \n"+
            "\\_| \\_|\\___||_| |_| |_| \\___/  \\_/  \\___| \\____/|_| |_| |_|| .__/ |_| \\___/  \\__, | \\___| \\___|            \n"+ 
            "                                                           | |                __/ |                        \n"+
            "                                                           |_|               |___/             "
        );
        System.out.println(Utils.printChar('═', 100));
        String newCode;
            do{
                if(this.size() > 0){ // If there're data in list
                    do{
                        System.out.print("CODE (E000): "); newCode = sc.nextLine().toUpperCase();
                        if(newCode.matches("^E\\d{3}$")){
                            int pos = find(newCode);
                            if(pos != -1){ // If that employee is existed
                                this.remove(pos);
                                System.out.println("Remove successfully!");
                                break;
                            }else{
                                Utils.showTextAndRetype("This CODE is not existed!");
                            }
                        }else{
                            Utils.showTextAndRetype("This CODE is not valid!");
                        }
                    }while(true);    
                }else{
                    System.out.println("There is no data!");
                }

                
            }while(Utils.wantToContinue());

    }

    /* Promote salary for employee */
    public void promoteSalary(){
        System.out.println(
            "______                               _          _____         _                     \n"+
            "| ___ \\                             | |        /  ___|       | |                    \n"+
            "| |_/ /_ __  ___   _ __ ___    ___  | |_  ___  \\ `--.   __ _ | |  __ _  _ __  _   _ \n"+
            "|  __/| '__|/ _ \\ | '_ ` _ \\  / _ \\ | __|/ _ \\  `--. \\ / _` || | / _` || '__|| | | |\n"+
            "| |   | |  | (_) || | | | | || (_) || |_|  __/ /\\__/ /| (_| || || (_| || |   | |_| |\n"+
            "\\_|   |_|   \\___/ |_| |_| |_| \\___/  \\__|\\___| \\____/  \\__,_||_| \\__,_||_|    \\__, |\n"+
            "                                                                               __/ |\n"+
            "                                                                              |___/"
        );
        System.out.println(Utils.printChar('═', 100));
        String newCode;
        int newSalary;
        Employee e;
        do{
            do{
                System.out.print("CODE (E000): "); newCode = sc.nextLine().toUpperCase();
                if(newCode.matches("^E\\d{3}$")){
                    int pos = find(newCode);
                    if(pos == -1){ // if that employee is not existed
                        Utils.showTextAndRetype("This CODE is not existed!");
                    }else{
                        e = this.get(pos);
                        break;
                    }
                }else{
                    Utils.showTextAndRetype("This CODE is not valid!");
                }
            }while(true);

            do{
                System.out.print("OLD SALARY IS "+ e.getSalary() +", NEW SALARY: "); 
                try{
                    newSalary = Integer.parseInt(sc.nextLine());
                    if(newSalary < 0){ // If salary is lower than zero
                        Utils.eraseLine(1);
                    }else if(newSalary < e.getSalary()){ // If salary is lower than current salary
                        Utils.showTextAndRetype("New salary must be greater than old salary");
                    }
                    else{
                        break;
                    }
                    
                }catch(Exception ex){
                    Utils.eraseLine(1);
                }
            }while(true);

            e.setSalary(newSalary);

            
        }while(Utils.wantToContinue());
    }

    /* List out all employees */
    public void listEmployee(){
        int maxWidthCol1 = 4, maxWidthCol2 = 4, maxWidthCol3 = 6;

        for(Employee e: this){
            if(maxWidthCol1 < e.getCode().length()){
                maxWidthCol1 = e.getCode().length();
            }

            if(maxWidthCol2 < e.getName().length()){
                maxWidthCol2 = e.getName().length();
            }

            if(maxWidthCol3 < String.valueOf(e.getSalary()).length()){
                maxWidthCol3 = String.valueOf(e.getSalary()).length();
            }
        }


        System.out.println(
            " _      _       _   \n"+
"| |    (_)     | |  \n"+
"| |     _  ___ | |_ \n"+
"| |    | |/ __|| __|\n"+
"| |____| |\\__ \\| |_ \n"+
"\\_____/|_||___/ \\__|\n"
        );

        System.out.println("╔" + Utils.printChar('═', maxWidthCol1 + maxWidthCol2 + maxWidthCol3 + 2) + "╗");

        System.out.println("║CODE" + Utils.printChar(' ', maxWidthCol1 - 4) + 
                            "║NAME" + Utils.printChar(' ', maxWidthCol2 - 4) + 
                            "║SALARY" + Utils.printChar(' ', maxWidthCol3 - 6) + "║");

        for(Employee e: this){
            String name = e.getName();
            String code = e.getCode();
            int salary = e.getSalary();

            System.out.println("║"+ code + Utils.printChar(' ', maxWidthCol1 - code.length()) + 
                            "║"+ name + Utils.printChar(' ', maxWidthCol2 - name.length()) + 
                            "║" + salary + Utils.printChar(' ', maxWidthCol3 - String.valueOf(salary).length()) + "║");
        }
        System.out.println("╚" + Utils.printChar('═', maxWidthCol1 + maxWidthCol2 + maxWidthCol3 + 2) + "╝");
        System.out.print("Press Enter to return to menu"); Utils.pause();
    }

    /* Sorting list by [CODE] */
    public void sortList(){
        Collections.sort(this);
    }

    /* Use linear search to find the position */
    private int find(String code){
        for(int i = 0; i < this.size(); i++){
            if(this.get(i).getCode().equals(code)){
                return i;
            }
        }
        return -1;
    }
}
