public class Student {
    String name;
    int age;
    int mark;
    public Student(String name, int age, int mark) {
        this.name = name.strip();
        this.age = age;
        this.mark = mark;
    }
    public String toString() {
        return (name + " " + age + " " + mark);
    }
}