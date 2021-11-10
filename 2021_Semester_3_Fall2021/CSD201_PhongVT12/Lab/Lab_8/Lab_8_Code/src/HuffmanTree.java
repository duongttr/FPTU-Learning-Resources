import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanTree implements Comparable < HuffmanTree > {
    Double freq;
    HuffmanTree left_node;
    HuffmanTree right_node;
    Character value;

    HuffmanTree(HuffmanTree ltree, HuffmanTree rtree) {
        this.freq = ltree.freq + rtree.freq;
        this.left_node = ltree;
        this.right_node = rtree;
    }
    HuffmanTree(Double freq, char val) {
        this.freq = freq;
        this.value = val;
        this.left_node = null;
        this.right_node = null;
    }
    HuffmanTree(HuffmanTree x) {
        this.freq = x.freq;
        this.left_node = x.left_node;
        this.right_node = x.right_node;
        this.value = x.value;
    }
    HuffmanTree() {}

    HashMap < Character,
    Integer > getFrequencyString(String s) {
        HashMap < Character, Integer > map = new HashMap < Character, Integer > ();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, val + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    void buildTree(String s) {
        HashMap < Character, Integer > dict = getFrequencyString(s);
        if (dict.size() < 2) {
            System.out.print("Number of unique characters must be >1");
            return;
        }
        // System.out.print(dict);
        PriorityQueue < HuffmanTree > min_heap = new PriorityQueue < HuffmanTree > ();
        for (char key: dict.keySet()) {
            HuffmanTree hf_node = new HuffmanTree(Double.valueOf(dict.get(key)), key);
            min_heap.add(hf_node);
        }
        while (min_heap.size() > 1) {
            HuffmanTree st_tree = min_heap.poll();
            HuffmanTree nd_tree = min_heap.poll();
            HuffmanTree merged_tree = merge_tree(nd_tree, st_tree);
            min_heap.add(merged_tree);
        }
        HuffmanTree final_tree = min_heap.poll();
        this.freq = final_tree.freq;
        this.left_node = final_tree.left_node;
        this.right_node = final_tree.right_node;
        this.value = final_tree.value;
    }
    void buildTreeFromDict(HashMap < Character, Double > dict) {
        if (dict.size() < 2) {
            System.out.print("Number of unique characters must be >1");
            return;
        }
        // System.out.print(dict);
        PriorityQueue < HuffmanTree > min_heap = new PriorityQueue < HuffmanTree > ();
        for (char key: dict.keySet()) {
            HuffmanTree hf_node = new HuffmanTree(dict.get(key), key);
            min_heap.add(hf_node);
        }
        while (min_heap.size() > 1) {
            HuffmanTree st_tree = min_heap.poll();
            HuffmanTree nd_tree = min_heap.poll();
            HuffmanTree merged_tree = merge_tree(nd_tree, st_tree);
            min_heap.add(merged_tree);
        }
        HuffmanTree final_tree = min_heap.poll();
        this.freq = final_tree.freq;
        this.left_node = final_tree.left_node;
        this.right_node = final_tree.right_node;
        this.value = final_tree.value;
    }
    void buildTreeFromDict2(HashMap < Character, Integer > dict) {
        if (dict.size() < 2) {
            System.out.print("Number of unique characters must be >1");
            return;
        }
        // System.out.print(dict);
        PriorityQueue < HuffmanTree > min_heap = new PriorityQueue < HuffmanTree > ();
        for (char key: dict.keySet()) {
            HuffmanTree hf_node = new HuffmanTree(Double.valueOf(dict.get(key)), key);
            min_heap.add(hf_node);
        }
        while (min_heap.size() > 1) {
            HuffmanTree st_tree = min_heap.poll();
            HuffmanTree nd_tree = min_heap.poll();
            HuffmanTree merged_tree = merge_tree(nd_tree, st_tree);
            min_heap.add(merged_tree);
        }
        HuffmanTree final_tree = min_heap.poll();
        this.freq = final_tree.freq;
        this.left_node = final_tree.left_node;
        this.right_node = final_tree.right_node;
        this.value = final_tree.value;
    }
    HashMap < String,
    Character > table;


    void traverse(HuffmanTree tree, String current) {
        if (current == null) {
            current = "";
            table = new HashMap < String, Character > ();
        }
        if (tree.value instanceof Character && tree.value != null) {
            // System.out.println()
            table.put(current, tree.value);
            return;
        }
        if (tree.left_node != null) {
            current += "0";
            traverse(tree.left_node, current);
            current = current.substring(0, current.length() - 1);
        }
        if (tree.right_node != null) {
            current += "1";
            traverse(tree.right_node, current);
            current = current.substring(0, current.length() - 1);
        }
        return;
    }
    HashMap < String,
    Character > getTranslate(HuffmanTree target) {
        if (target instanceof HuffmanTree == false) {
            return null;
        }
        traverse(target, null);
        return table;
    }

    HuffmanTree merge_tree(HuffmanTree ltree, HuffmanTree rtree) {
        HuffmanTree merged_tree = new HuffmanTree(ltree, rtree);
        return merged_tree;
    }

    void create_tree(String s) {

    }
    @Override
    public int compareTo(HuffmanTree o) {
        if (this.freq > o.freq) {
            return 1;
        };
        if (this.freq < o.freq) {
            return -1;
        };
        return 0;
    }
}