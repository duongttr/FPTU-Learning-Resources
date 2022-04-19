public class App {
    public static void main(String[] args) {
        Hash hash = new Hash();
        hash.insert(new Student("Nam", 15, 23));
        hash.insert(new Student("Tu", 20, 25));
        hash.insert(new Student("Cuong", 40, 25));
        hash.insert(new Student("Trong", 10, 25));
        hash.insert(new Student("Nghia", 41, 12));
        hash.insert(new Student("Duong", 12, 63));
        hash.insert(new Student("An", 52, 36));
        hash.insert(new Student("Vinh", 52, 36));
        hash.search("Vinh");
        hash.search("Hai");
    }

    
}
