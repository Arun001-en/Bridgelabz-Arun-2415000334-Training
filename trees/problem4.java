public class problem4 {
    class StudentBST {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    // Insert node
    static Node insert(Node root, int value) {

        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);

        else
            root.right = insert(root.right, value);

        return root;
    }

    // Find minimum value node (inorder successor)
    static Node minValue(Node root) {

        while (root.left != null)
            root = root.left;

        return root;
    }

    // Delete node
    static Node delete(Node root, int key) {

        if (root == null)
            return null;

        if (key < root.data)
            root.left = delete(root.left, key);

        else if (key > root.data)
            root.right = delete(root.right, key);

        else {

            // Case 1: No child
            if (root.left == null && root.right == null)
                return null;

            // Case 2: One child
            else if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

            // Case 3: Two children
            Node successor = minValue(root.right);

            root.data = successor.data;

            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    // Inorder Traversal
    static void inorder(Node root) {

        if (root != null) {

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);

        }
    }

    // Print values within range
    static void rangeSearch(Node root, int low, int high) {

        if (root == null)
            return;

        if (root.data > low)
            rangeSearch(root.left, low, high);

        if (root.data >= low && root.data <= high)
            System.out.print(root.data + " ");

        if (root.data < high)
            rangeSearch(root.right, low, high);
    }

    public static void main(String[] args) {

        Node root = null;

        int arr[] = {15, 10, 20, 8, 12, 17, 25};

        // Create BST
        for (int i : arr)
            root = insert(root, i);

        // Delete node 10
        root = delete(root, 10);

        System.out.print("After deleting 10: ");
        inorder(root);

        // Insert 14
        root = insert(root, 14);

        // Insert 9
        root = insert(root, 9);

        System.out.print("\nAfter inserting 14 and 9: ");
        inorder(root);

        // Range search
        System.out.print("\nRoll numbers between 10 and 20: ");
        rangeSearch(root, 10, 20);

    }
}
}
