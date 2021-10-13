package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST_String {
    private static class Node {
        String value;
        Node left;
        Node right;

        Node(String v) {
            value = v;
        }
    }

    int size = 0;
    Node root = null;

    public boolean isEmpty() {
        return size == 0;
    }

    public int count() {
        return size;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public Node search(String x) {
        return searchRecursion(this.root, x);
    }

    private Node searchRecursion(Node node, String x) {
        if (node != null) {
            if (x.compareTo(node.value) < 0)
                return searchRecursion(node.left, x);
            else if (x.compareTo(node.value) > 0)
                return searchRecursion(node.right, x);
            else
                return node;
        }
        return null;
    }

    public void insert(String x) {
        if(isEmpty()){
            root = new Node(x);
            size++;
            return;
        }
        insertRecursion(this.root, x);
        
    }

    private void insertRecursion(Node node, String x) {
        if (node != null) {
            if (x.compareTo(node.value) < 0) {
                if(node.left == null){
                    size++;
                    node.left = new Node(x);
                }
                    
                else insertRecursion(node.left, x);
            } else if (x.compareTo(node.value) > 0) {
                if(node.right == null){
                    node.right = new Node(x);
                    size++;
                }
                else insertRecursion(node.right, x);
            }
        }
    }

    private void visit(Node x) {
        System.out.print(x.value + ", ");
    }

    public void breath() {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node p = null;
        while (!q.isEmpty()) {
            p = q.poll();
            if (p.left != null)
                q.add(p.left);
            if (p.right != null)
                q.add(p.right);
            visit(p);
        }
        System.out.println();
    }

    public void preorder() {
        preorderRecursion(root);
        System.out.println();
    }

    private void preorderRecursion(Node p) {
        if (p == null)
            return;
        visit(p);
        preorderRecursion(p.left);
        preorderRecursion(p.right);
    }

    public void inorder() {
        inorderRecursion(root);
        System.out.println();
    }

    private void inorderRecursion(Node p) {
        if (p == null)
            return;
        inorderRecursion(p.left);
        visit(p);
        inorderRecursion(p.right);
    }

    public void postorder() {
        postorderRecursion(root);
        System.out.println();
    }

    private void postorderRecursion(Node p) {
        if (p == null)
            return;
        postorderRecursion(p.left);
        postorderRecursion(p.right);
        visit(p);
    }

    public void delete(String x) {
        deleteRecursion(root, x);
    }

    private boolean deleteRecursion(Node node, String x) {
        if (node != null) {
            if (x.compareTo(node.value) < 0)
                if(deleteRecursion(node.left, x)){
                    node.left = null;
                    return false;
                }
            else if (x.compareTo(node.value) > 0)
                if(deleteRecursion(node.right, x)){
                    node.right = null;
                    return false;
                }
            else {
                size--;
                return true;
            }
        }
        return false;
    }

    public String min() {
        if (isEmpty()) {
            System.out.println("The tree is empty!");
        }

        Node t = root;
        String ret = "";
        while (t != null) {
            ret = t.value;
            t = t.left;
        }
        return ret;
    }

    public String max() {
        if (isEmpty()) {
            System.out.println("The tree is empty!");
        }

        Node t = root;
        String ret = "";
        while (t != null) {
            ret = t.value;
            t = t.right;
        }
        return ret;
    }

    public int height() {
        return heightRecursion(root);
    }

    public int heightRecursion(Node node) {
        if (node != null) {
            int leftHeight = 0;
            int rightHeight = 0;
            if (node.left != null)
                leftHeight = 1 + heightRecursion(node.left);
            if (node.right != null)
                rightHeight = 1 + heightRecursion(node.right);
            return Math.max(leftHeight, rightHeight);
        }
        return 0;
    }
    public boolean isAVL() {
        return isAVLRecursion(root, new Height());
    }

    private class Height {
        int height = 0;
    }

    private boolean isAVLRecursion(Node node, Height height) {
        if (root == null) {
            height.height = 0;
            return true;
        }

        Height lheight = new Height(), rheight = new Height();
        boolean l = isAVLRecursion(root.left, lheight);
        boolean r = isAVLRecursion(root.right, rheight);
        int lh = lheight.height, rh = rheight.height;

        height.height = (lh > rh ? lh : rh) + 1;

        if (Math.abs(lh - rh) >= 2)
            return false;

        else
            return l && r;
    }
}
