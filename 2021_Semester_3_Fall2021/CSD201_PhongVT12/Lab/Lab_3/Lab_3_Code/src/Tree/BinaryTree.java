package Tree;

public class BinaryTree {
    Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public int calculateHeight() {
        return calculateHeightRecursion(root);
    }

    private int calculateHeightRecursion(Node root) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            // Get the height of the left sub-tree + 1 (current node)
            leftHeight = calculateHeightRecursion(root.left) + 1;
        }
        if (root.right != null) {
            // Get the height of the right sub-tree + 1 (current node)
            rightHeight = calculateHeightRecursion(root.right) + 1;
        }

        // Get max height from left and right subtree
        return Math.max(leftHeight, rightHeight);
    }

    public int calculateSize() {
        return calculateSizeRecursion(root) + 1;
    }

    public int calculateSizeRecursion(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSize = 0;
        int rightSize = 0;
        if (root.left != null) {
            leftSize = 1 + calculateSizeRecursion(root.left);
        }
        if (root.right != null) {
            rightSize = 1 + calculateSizeRecursion(root.right);
        }

        return leftSize + rightSize;
    }
}
