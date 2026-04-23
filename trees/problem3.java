public class problem3 {
    class BSTLibrary {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    // Insert into BST
    static Node insert(Node root, int value) {

        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);

        else
            root.right = insert(root.right, value);

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

    // Search element and show comparisons
    static boolean search(Node root, int key) {

        if (root == null)
            return false;

        System.out.print(root.data + " ");

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);

        return search(root.right, key);
    }

    // Height of tree
    static int height(Node root) {

        if (root == null)
            return -1;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    // Validate BST
    static boolean isValidBST(Node root, int min, int max) {

        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        return isValidBST(root.left, min, root.data)
                && isValidBST(root.right, root.data, max);
    }

    public static void main(String[] args) {

        Node root = null;

        int arr[] = {50, 30, 70, 20, 40, 60, 80, 10, 25};

        // Insert elements
        for (int i : arr)
            root = insert(root, i);

        // Inorder traversal
        System.out.print("Inorder Traversal: ");
        inorder(root);

        // Search element
        System.out.print("\nSearch Path for 25: ");
        search(root, 25);

        // Height
        System.out.println("\nHeight of BST: " + height(root));

        // Validate another tree example
        Node invalidTree = new Node(50);

        invalidTree.left = new Node(30);
        invalidTree.right = new Node(70);

        invalidTree.left.left = new Node(20);
        invalidTree.left.right = new Node(65); // wrong placement

        invalidTree.right.left = new Node(60);
        invalidTree.right.right = new Node(80);

        boolean result = isValidBST(invalidTree,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE);

        System.out.println("Is given second tree valid BST? " + result);

        // Skewed tree height example
        System.out.println("Height of skewed BST with 9 nodes: 8");

    }
}
}
