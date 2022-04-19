public class Employee implements Comparable<Employee>{
    String id;
    String name;
    int level;
    public Employee(String id,String name,int level){
        this.id=id;
        this.name=name;
        this.level=level;
    }
    @Override
    public int compareTo(Employee e) {
        return this.id.compareTo(e.id);
    }
    public String toString(){
        return(this.id+" "+this.name+" "+this.level);
    }

}
