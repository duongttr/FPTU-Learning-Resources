package items;

public class Item {
    private String code, name;
    private int price;

    public Item(String c, String n, int p) {
        this.code = c;
        this.name = n;
        this.price = p;
    }

    public void print() {
        System.out.println("---------------------");
        System.out.println("Item's detail: ");
        System.out.println("Code: " + code);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
