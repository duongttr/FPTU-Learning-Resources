/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author jaydentran1909
 */
public class StudentList extends ArrayList<Student> {
    public StudentList() {
        super();
    }

    public Student search(String code) {
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCode().equals(code)) {
                return this.get(i);
            }
        }
        return null;
    }

    private boolean isCodeDuplicated(String code) {
        for (Student s : this)
            if (s.getCode().equals(code))
                return true;
        return false;
    }

    public void addStudent() {
        String newCode, newName;
        int newMark;
        boolean isCodeDuplicated = false;
        do {
            newCode = Inputter.inputPattern("Code (S000): ", "^[sS][\\d]{3}$");
            newCode = newCode.trim().toUpperCase();
            isCodeDuplicated = isCodeDuplicated(newCode);
            if (isCodeDuplicated)
                System.out.println("Code is duplicated");
        } while (isCodeDuplicated);

        newName = Inputter.inputNonBlankString("Name: ");
        newName = newName.toUpperCase();

        newMark = Inputter.inputInt("Mark (0..10): ", 0, 10);

        Student s = new Student(newCode, newName, newMark);

        this.add(s);
        System.out.println("Student " + newCode + " has been added!");
    }

    public void searchStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            String sCode = Inputter.inputNonBlankString("Input search student code: ");
            Student s = this.search(sCode);
            if (s == null) {
                System.out.println("Student " + sCode + " doesn't existed");
            } else {
                System.out.println("Found: " + s);
            }
        }
    }

    public void removeStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            String rCode = Inputter.inputNonBlankString("Input removed code: ");
            Student s = this.search(rCode);
            if (s == null) {
                System.out.println("Student " + rCode + " doesn't existed");
            } else {
                this.remove(s);
                System.out.println("Student " + rCode + "has been removed!");
            }
        }
    }

    public void printAll() {
        if (this.isEmpty())
            System.out.println("Empty list!");
        else {
            System.out.println("Student list: ");
            for (Student s : this)
                System.out.println(s);
            System.out.println("Total: " + this.size());
        }
    }

    public void updateStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            String uCode = Inputter.inputNonBlankString("Input updated code: ");
            Student s = this.search(uCode);
            if (s == null) {
                System.out.println("Student " + uCode + " doesn't exist");
            } else {

                // Update name
                String oldName = s.getName();
                String msg = "Old name: " + oldName + ", new name:";
                String newName = Inputter.inputNonBlankString(msg);
                s.setName(newName);

                // Update mark
                int oldMark = s.getMark();
                msg = "Old mark: " + oldMark + ", new mark: ";
                int newMark = Inputter.inputInt(msg, 0, 10);
                s.setMark(newMark);
                System.out.println("Student " + uCode + " has been updated");
            }
        }
    }

    public void sortStudent(int option) {
        // 1 - code, 2 - name, 3 - mark
        Comparator<Student> byCode = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getCode().compareTo(o2.getCode());
            }

        };

        Comparator<Student> byName = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }

        };

        Comparator<Student> byMark = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getMark() < o2.getMark()) {
                    return -1;
                } else if (o1.getMark() > o2.getMark()) {
                    return 1;
                }
                return 0;
            }

        };
        if (option == 1) {
            this.sort(byCode);
        } else if (option == 2) {
            this.sort(byName);
        } else if (option == 3) {
            this.sort(byMark);
        }

    }
}
