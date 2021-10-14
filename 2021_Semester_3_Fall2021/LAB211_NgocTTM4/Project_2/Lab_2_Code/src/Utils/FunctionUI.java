package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Objects.*;
import Utils.Message.MessageKind;

public class FunctionUI implements Functions {

    static String baseDataFolder = "data";
    public static StudentList studentList;
    public static VaccineList vaccineList;
    static InjectionList il;
    static Date startedDate;
    static Date currentDate;
    static SimpleDateFormat sdf;
    static long FOUR_WEEKS = 4 * 7 * 24 * 60 * 60 * 1000;
    static long TWELVE_WEEKS = 12 * 7 * 24 * 60 * 60 * 1000;

    static {
        studentList = new StudentList();
        vaccineList = new VaccineList();
        il = new InjectionList();

        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        currentDate = c.getTime();

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.MONTH, 2);
        c1.set(Calendar.DAY_OF_MONTH, 7);
        c1.set(Calendar.YEAR, 2021);
        c1.set(Calendar.HOUR_OF_DAY, 23);
        c1.set(Calendar.MINUTE, 59);
        c1.set(Calendar.SECOND, 59);
        startedDate = c1.getTime();

        sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        String studentFile = baseDataFolder + "/" + "student.txt";
        String vaccineFile = baseDataFolder + "/" + "vaccine.txt";

        // Load student list
        try {
            File f = new File(studentFile);
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(";");
                if (data.length == 2) {
                    studentList.add(new Student(data[0], data[1]));
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            Message.show("File is not found!", MessageKind.ERROR);
        }

        // Load vaccine list

        try {
            File f = new File(vaccineFile);
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(";");
                if (data.length == 2) {
                    vaccineList.add(new Vaccine(Integer.parseInt(data[0]), data[1]));
                }
            }

            sc.close();
        } catch (FileNotFoundException e) {
            Message.show("File is not found!", MessageKind.ERROR);
        }

    }

    public static void pause() {
        // pause
        Inputter.getString("", false, false);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void showInfo() {
        clearScreen();
        printREADME("show.txt");
        if (il.size() == 0) {
            Message.show("List is empty", MessageKind.WARNING);
            pause();
            return;
        }
        il.show();

        pause();
    }

    @Override
    public void addInjection() {
        do {
            clearScreen();
            printREADME("add.txt");
            System.out.println("Add injection");

            Injection inj = new Injection();
            Student stu;
            Vaccine vac;

            Injection checkedInj;
            do {
                String injId = Inputter.getString("Input injection id: ", true, true).toUpperCase();
                checkedInj = il.search(injId);
                if (checkedInj != null) {
                    Message.show("This injection exists", MessageKind.WARNING);
                } else {
                    inj.setId(injId);
                }
            } while (checkedInj != null);

            // Input stu
            showStudentInfo();
            do {
                String stuId = Inputter.getString("Input student id: ", true, true).toUpperCase();
                stu = studentList.search(stuId);
                if (stu == null) {
                    Message.show("This student does not exist", MessageKind.WARNING);
                } else {
                    if (il.searchByStudentId(stuId) == null)
                        inj.setStudentID(stu.getId());
                    else {
                        Message.show("This student is already injected", MessageKind.WARNING);
                        stu = null;
                    }
                }
            } while (stu == null);

            input_vaccine: {
                do {
                    showVaccineInfo();
                    int vacId = Inputter.getInt("Input vaccine id: ", true);

                    vac = vaccineList.search(vacId);
                    if (vac == null) {
                        Message.show("This vaccine does not exist", MessageKind.WARNING);
                    } else {
                        inj.setVaccineID(vac.getId());
                    }
                } while (vac == null);

                // input 1st place, date
                //showPlaceInfo();
                
                while(true){
                String placeStr = Inputter.getString("Input 1st place: ", true, true);
                if(!suggestionPlace(placeStr)){
                    Message.show("There's no suggestion, please type again!", MessageKind.WARNING);
                }else break;
            }
                int placeId = Inputter.getIntWithCondition("Input 1st place id: ", true, new Predicate<Integer>() {

                    @Override
                    public boolean test(Integer t) {
                        if (t < 1 || t > Injection.PROVICES.length) {
                            Message.show("The place id is out of range [1..63]", MessageKind.WARNING);
                            return false;
                        }
                        return true;
                    }

                });

                inj.setFirstInjectionPlace(placeId);

                Date injDate;

                while (true) {
                    String date = Inputter.getStringWithPattern("Input 1st date (dd/MM/yyyy): ", true,
                            "\\d{1,2}/\\d{1,2}/\\d{1,4}");
                    try {
                        injDate = sdf.parse(date);
                        // System.out.println(injDate.toString());
                        // System.out.println(startedDate.toString());
                        if (injDate.compareTo(startedDate) < 0) {
                            Message.show("The started day is 8/3/2021", MessageKind.WARNING);
                            continue;
                        }
                        if (injDate.compareTo(currentDate) > 0) {
                            Message.show("You need to input the date in the past", MessageKind.WARNING);
                            continue;
                        }
                        break;
                    } catch (ParseException e) {

                        Message.show("Invalid date!", MessageKind.WARNING);
                    }
                }

                inj.setFirstInjectionDate(injDate);
                ////
                ////
                ////

                ////
                if (plusDays(inj.getFirstInjectionDate(), 4 * 7).getTime() > currentDate.getTime()) {
                    Message.show("The 2nd injection is date in the future", MessageKind.INFORMATION);
                    break input_vaccine;
                }

                //showPlaceInfo();

                while(true){
                    String placeStr = Inputter.getString("Input 2nd place: ", true, true);
                    if(!suggestionPlace(placeStr)){
                        Message.show("There's no suggestion, please type again!", MessageKind.WARNING);
                    }else break;
                }
                int placeId2 = Inputter.getIntWithCondition("Input 2nd place id (type 0 for stopping): ", true, new Predicate<Integer>() {

                    @Override
                    public boolean test(Integer t) {
                        if (t < 0 || t > Injection.PROVICES.length) {
                            Message.show("The place id is out of range [1..63]", MessageKind.WARNING);
                            return false;
                        }
                        return true;
                    }

                });
                if (placeId2 == 0) {
                    break input_vaccine;
                }
                inj.setSecondInjectionPlace(placeId2);
                Date injDate2 = null;

                while (true) {
                    String date = Inputter.getStringWithPattern("Input 2nd date (dd/MM/yyyy): ", true,
                            "\\d{1,2}/\\d{1,2}/\\d{1,4}");
                    try {
                        injDate2 = sdf.parse(date);
                        // System.out.println(startedDate.toString());
                        if (injDate2.compareTo(startedDate) < 0) {
                            Message.show("The started day is 8/3/2021", MessageKind.WARNING);
                            continue;
                        }
                        if (injDate2.compareTo(currentDate) > 0) {
                            Message.show("You need to input the date in the past", MessageKind.WARNING);
                            continue;
                        }
                        if (!validRange(inj.getFirstInjectionDate(), injDate2)) {
                            Message.show("You date must be in range 4 to 12 weeks to the first injection",
                                    MessageKind.WARNING);
                            continue;
                        }
                        break;
                    } catch (ParseException e) {

                        Message.show("Invalid date!", MessageKind.WARNING);
                    }
                }

                inj.setSecondInjectionDate(injDate2);

            }
            il.add(inj);

        } while (Inputter.askYN("Do you want to continue? (Y/N): "));
    }

    @Override
    public void updateInjection() {

        do {
            clearScreen();
            printREADME("update.txt");
            if (il.size() == 0) {
                Message.show("List is empty", MessageKind.WARNING);
                pause();
                return;
            }
            String id = Inputter.getString("Input injection id to update:", true, true).toUpperCase();
            Injection inj = il.search(id);
            if (inj == null) {
                Message.show("This injection does not exist", MessageKind.WARNING);
            } else {
                if (inj.getFirstInjectionDate() != null && inj.getSecondInjectionDate() != null) {
                    Message.show("This student is fully injected", MessageKind.WARNING);
                } else {
                    if (plusDays(inj.getFirstInjectionDate(), 4 * 7).getTime() > currentDate.getTime()) {
                        Message.show("This student need to wait for next injection", MessageKind.INFORMATION);

                    } else {
                        InjectionList tmpList = new InjectionList();
                        tmpList.add(inj);
                        tmpList.show();

                        while(true){
                            String placeStr = Inputter.getString("Input 2nd place: ", true, true);
                            if(!suggestionPlace(placeStr)){
                                Message.show("There's no suggestion, please type again!", MessageKind.WARNING);
                            }else break;
                        }
                        int placeId2 = Inputter.getIntWithCondition("Input 2nd place id: ", true,
                                new Predicate<Integer>() {

                                    @Override
                                    public boolean test(Integer t) {
                                        if (t <= 0 || t > Injection.PROVICES.length) {
                                            Message.show("The place id is out of range [1..63]", MessageKind.WARNING);
                                            return false;
                                        }
                                        return true;
                                    }

                                });

                        inj.setSecondInjectionPlace(placeId2);
                        Date injDate2 = null;

                        while (true) {
                            String date = Inputter.getStringWithPattern("Input 2nd date (dd/MM/yyyy): ", true,
                                    "\\d{1,2}/\\d{1,2}/\\d{1,4}");
                            try {
                                injDate2 = sdf.parse(date);
                                // System.out.println(startedDate.toString());
                                if (injDate2.compareTo(startedDate) < 0) {
                                    Message.show("The started day is 8/3/2021", MessageKind.WARNING);
                                    continue;
                                }
                                if (injDate2.compareTo(currentDate) > 0) {
                                    Message.show("You need to input the date in the past", MessageKind.WARNING);
                                    continue;
                                }
                                if (!validRange(inj.getFirstInjectionDate(), injDate2)) {
                                    Message.show("You date must be in range 4 to 12 weeks to the first injection",
                                            MessageKind.WARNING);
                                    continue;
                                }
                                break;
                            } catch (ParseException e) {

                                Message.show("Invalid date!", MessageKind.WARNING);
                            }
                        }

                        inj.setSecondInjectionDate(injDate2);
                        Message.show("UPDATE SUCCESSFULLY", MessageKind.SUCCESS);
                    }

                }
            }
        } while (Inputter.askYN("Do you want to continue? (Y/N): "));
    }

    private static void showStudentInfo() {
        System.out.println("STUDENTS");
        TableDrawer stuTD = new TableDrawer("ID", "Student Name");

        for (Student stu : studentList)
            stuTD.add(stu.getId(), stu.getName());

        stuTD.show(false);

    }

    private static void showPlaceInfo() {
        String[] p = Injection.PROVICES;
        for (int i = 0; i < p.length; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(String.format("%d. %-" + (25 + (i >= 0 && i <= 8 ? 1 : 0)) + "s", i + 1, p[i]));

        }
        System.out.println();
    }

    private static void showVaccineInfo() {
        TableDrawer vacTD = new TableDrawer("ID", "Vaccine Name");
        System.out.println("\nVACCINES");
        for (Vaccine vac : vaccineList)
            vacTD.add(vac.getId() + "", vac.getName());

        vacTD.show(false);
    }

    // check if 2 vaccines distance is 4 to 12 weeks
    private static boolean validRange(Date fDate, Date sDate) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(fDate);
        c2.setTime(sDate);
        long day = ChronoUnit.DAYS.between(c1.toInstant(), c2.toInstant());

        return day >= 4 * 7 && day <= 12 * 7;
    }

    private static Date plusDays(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    @Override
    public void deleteInjection() {

        do {
            clearScreen();
            printREADME("delete.txt");
            if (il.size() == 0) {
                Message.show("List is empty", MessageKind.WARNING);
                pause();
                return;
            }
            String id = Inputter.getString("Input injection id to delete: ", true, true).toUpperCase();
            Injection inj = il.search(id);
            if (il.search(id) == null) {
                Message.show("This injection does not exist", MessageKind.WARNING);
            } else {
                // show information
                InjectionList tmpList = new InjectionList();
                tmpList.add(inj);
                tmpList.show();
                if (Inputter.askYN("Do you want to delete this injection? (Y/N): ")) {
                    il.remove(inj);
                    Message.show("DELETE SUCCESSFULLY!", MessageKind.SUCCESS);
                }
            }
        } while (Inputter.askYN("Do you want to continue? (Y/N): "));
    }

    @Override
    public void searchByStudentId() {

        do {
            clearScreen();
            printREADME("search.txt");
            if (il.size() == 0) {
                Message.show("List is empty", MessageKind.WARNING);
                pause();
                return;
            }
            String stuId = Inputter.getString("Input student id: ", true, true).toUpperCase();
            Injection inj = il.searchByStudentId(stuId);
            if (inj == null) {
                Message.show("This injection does not exist", MessageKind.WARNING);
            } else {
                InjectionList tmpList = new InjectionList();
                tmpList.add(inj);
                tmpList.show();
            }
        } while (Inputter.askYN("Do you want to continue? (Y/N): "));
    }

    public void searchByVaccineId() {

        do {
            clearScreen();
            printREADME("search.txt");
            if (il.size() == 0) {
                Message.show("List is empty", MessageKind.WARNING);
                pause();
                return;
            }
            int vacId = Inputter.getInt("Input vaccine id: ", true);
            InjectionList tmpList = new InjectionList();
            for(Injection inj: il){
                if(inj.getVaccineID() == vacId){
                    tmpList.add(inj);
                }
            }
            if(tmpList.size() == 0){
                Message.show("There is no injection with this vaccine id", MessageKind.WARNING);
            }else{
                tmpList.show();
            }
        } while (Inputter.askYN("Do you want to continue? (Y/N): "));
    }



    @Override
    public void storeToFile() {
        clearScreen();
        printREADME("save.txt");
        try {
            File file = new File("injection.dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(il);
            oos.flush();
            oos.close();
            Message.show("SAVE FILE SUCCESSFULLY!", MessageKind.SUCCESS);
        } catch (Exception e) {
            Message.show("An error occured, please try again!", MessageKind.ERROR);
        }
        pause();
    }

    public static void printREADME(String filename) {
        String path = "README" + "/" + filename;

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

    private boolean suggestionPlace(String s){
        String[] p = Injection.PROVICES;
        String input = deAccent(s).toUpperCase();
        input = input.replaceAll("\\s+", " ").trim();
        int count = 0;
        for(int i = 0; i < p.length;i++){
            String t = deAccent(p[i]).toUpperCase();
            
            if(input.matches(t) ||
            input.replaceAll("\\s+", "").matches(t.replaceAll("\\s+", ""))){
                System.out.println(String.format("%d. %s", i+1, p[i]));
                count++;
                continue;
            }

            // check every word
            String[] WORDS = t.split(" ");
            
            for(int jj = 0; jj < WORDS.length;jj++){
                WORDS[jj] = ".*"+WORDS[jj]+".*";
            }
            String tmpPattern = String.join("|", WORDS);
            Pattern r = Pattern.compile(tmpPattern);
            Matcher m = r.matcher(input);
            if(m.matches()){
                count++;
                System.out.println(String.format("%d. %s", i+1, p[i]));
                continue;
            }
        }
        return count != 0;
    }

    private String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    @Override
    public void loadFromFile(){
        File f = new File("injection.dat");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            il = (InjectionList) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            Message.show("An error occured", MessageKind.ERROR);
            //e.printStackTrace();
        }
        
    }
}
