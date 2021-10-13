import Tree.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {

        int n = 20;
        System.out.println("Sum from 1 to "+n+": " + Recursion.sum(n));

        int[] arr = new int[]{1,0,-1,3,4,2};
        int size = arr.length;
        System.out.println("Min value in array: " + Recursion.findmin(arr, size));

        System.out.println("Sum array: " + Recursion.findsum(arr, size));

        char[] text = new char[]{'a', 'b', 'c', 'b', 'a', 'c'};
        System.out.println("Check palindrome "+ String.copyValueOf(text) +": " + Recursion.ispalindrome(text, text.length));

        int[] arr2 = new int[]{1, 2};
        int target = 3;
        System.out.println("Binary search for " + target + ": " + Recursion.binarysearch(arr2, 0, arr2.length-1, target));
    
        int a = 13;
        int b = 10;
        System.out.println(String.format("GCD(%d,%d)=%d",a,b, Recursion.GCD(a, b)));

        int x = 12;
        int n2 = 2;
        System.out.println(String.format("%d^%d=%d", x, n2, Recursion.power(x, n2)));

        System.out.println(Recursion.addReciprocal(5));

        BinaryTree bt = new BinaryTree();
        bt.add(3);
        bt.add(5);
        bt.add(1);
        bt.add(4);
        bt.add(7);
        bt.add(10);
        /*      3
               / \
              /   \
             1     5
                  / \
                 4   7
                      \
                       10
        */   

        System.out.println(String.format("Height of binary tree: %d", bt.calculateHeight()));
        System.out.println(String.format("Size of binary tree: %d", bt.calculateSize()));
    }
}
