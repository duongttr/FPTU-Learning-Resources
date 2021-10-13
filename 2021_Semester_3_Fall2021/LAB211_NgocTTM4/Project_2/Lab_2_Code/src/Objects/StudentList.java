package Objects;

import java.util.Vector;

public class StudentList extends Vector<Student> {
    public StudentList(){
        
    }

    public Student search(String id){
        for(Student stu: this){
            if(stu.getId().equals(id))
                return stu;
        }
        return null;
    }
}
