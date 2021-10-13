package Objects;

public class Vaccine {
    private int id;
    private String name;

    
    public Vaccine(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    
}
