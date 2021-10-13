import Trees.BST;
import Trees.BST.Node;

public class App {
    public static void main(String[] args) throws Exception {
        BST tree = new BST();
        tree.insert(1);
        tree.insert(2);
        tree.insert(0);
        tree.insert(10);
        tree.insert(11);
        tree.insert(8);
        tree.insert(9);
        tree.insert(-1);
        tree.insert(2);
        tree.insert(50);
        tree.insert(-2);
        tree.insert(-3);
        tree.insert(-10);
        tree.insert(-5);
        tree.insert(-4);
        tree.insert(100);

        System.out.print("Traverse the tree: ");
        tree.breath();
        
        System.out.print("Preorder of tree: ");
        tree.preorder();
        
        System.out.print("Inorder of tree: ");
        tree.inorder();

        System.out.print("Postorder of tree: ");
        tree.postorder();

        System.out.println("Size of tree: " + tree.count());
        
        Node node1 = tree.search(2);
        System.out.println("Node with value 2 is existed?: " + (node1 != null));
        
        Node node2 = tree.search(100);
        System.out.println("Node with value 100 is existed?: " + (node2 != null));

        tree.delete(50);
        System.out.print("Delete value 50: "); tree.breath();

        System.out.println("Min value: " + tree.min());
        System.out.println("Max value: " + tree.max());
        System.out.println("Avg value: " + tree.avg());
        System.out.println("Most expensive cost: " + tree.cost());
        System.out.println("Height of tree: " + tree.height());
        System.out.println("is AVL: " + tree.isAVL());
        System.out.println("is Heap: " + tree.isHeap());

        tree.clear();
        System.out.println("Tree size after clearing: " + tree.count()); tree.breath();
    }
}
