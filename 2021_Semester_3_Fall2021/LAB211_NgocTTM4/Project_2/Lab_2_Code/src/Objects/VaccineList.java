package Objects;

import java.util.Vector;

public class VaccineList extends Vector<Vaccine> {

    public VaccineList(){
        
    }

    public Vaccine search(int id){
        for(Vaccine vac: this){
            if(vac.getId() == id)
                return vac;
        }
        return null;
    }
    
}
