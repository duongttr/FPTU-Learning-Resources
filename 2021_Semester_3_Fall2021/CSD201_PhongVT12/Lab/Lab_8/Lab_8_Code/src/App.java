import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        HashMap<Character, Double> dict1=new HashMap<>();
        dict1.put('a', 0.5);
        dict1.put('b', 0.25);
        dict1.put('c', 0.15);
        dict1.put('d', 0.15);
        dict1.put('e', 0.35);

        System.out.println("Source:" + dict1.toString());

        HuffmanTree b = new HuffmanTree();
        b.buildTreeFromDict(dict1);
        HashMap<String,Character> table1 = b.getTranslate(b);
        System.out.println(table1+"\n");

        HashMap<Character,Integer> dict2=new HashMap<>();
        dict2.put('a', 15);
        dict2.put('b', 5);
        dict2.put('c', 45);
        dict2.put('d', 12);
        dict2.put('e', 48);
        dict2.put('f', 58);
        dict2.put('g', 8);

        System.out.println("Source:" + dict2.toString());

        HuffmanTree c=new HuffmanTree();
        c.buildTreeFromDict2(dict2);
        HashMap<String,Character> table2=b.getTranslate(c);
        System.out.println(table2+"\n");
    
        HuffmanTree a=new HuffmanTree();
        a.buildTree("tran thanh duong");
        HashMap<String,Character> table=a.getTranslate(a);
        System.out.println(table);

    }

    // input a string and count every character and put it into dictionary
    public static HashMap<Character, Integer> countChar(String str) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c) + 1);
            } else {
                dict.put(c, 1);
            }
        }
        return dict;
    }
}
