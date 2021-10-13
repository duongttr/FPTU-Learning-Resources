package Objects;

import java.text.SimpleDateFormat;
import java.util.Vector;

import Utils.FunctionUI;
import Utils.TableDrawer;

public class InjectionList extends Vector<Injection> {

    SimpleDateFormat sdf;
    public InjectionList(){
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public Injection search(String id){
        for(Injection inj: this){
            if(inj.getId().equals(id))
                return inj;
        }
        return null;
    }

    public Injection searchByStudentId(String stuId) {
        for(Injection inj: this){
            if(inj.getStudentID().equals(stuId))
                return inj;
        }
        return null;
    }

    
    
    public void show(){
        TableDrawer iTD = new TableDrawer("Injection Id", "Student Id", "Student Name", "Vaccine Name",
                "1st injection place", "1st injection date", "2nd injection place", "2nd injection date");

        for (Injection inj : this) {
            String firstPlace = "null", secondPlace = "null";
            if(inj.getFirstInjectionPlace()-1 >= 0)
                firstPlace = Injection.PROVICES[inj.getFirstInjectionPlace()-1];
            if(inj.getSecondInjectionPlace()-1 >= 0)
                secondPlace = Injection.PROVICES[inj.getSecondInjectionPlace()-1];

            String firstDate = "null", seconDate = "null";
            if(inj.getFirstInjectionDate() != null)
                firstDate = sdf.format(inj.getFirstInjectionDate());
            if(inj.getSecondInjectionDate() != null)
                seconDate = sdf.format(inj.getSecondInjectionDate());
            iTD.add(inj.getId(), inj.getStudentID(), FunctionUI.studentList.search(inj.getStudentID()).getName(),
                    FunctionUI.vaccineList.search(inj.getVaccineID()).getName(),
                    firstPlace, firstDate,
                    secondPlace, seconDate);
        }

        iTD.show(true);
    }
    
}
