public class problem5 {
    class ExpressionTree {

    static class Node {
        String data;
        Node left, right;

        Node(String value) {
            data = value;
            left = right = null;
        }
    }

    // Inorder traversal
    static void inorder(Node root) {

        if (root != null) {

            if (root.left != null)
                System.out.print("(");

            inorder(root.left);

            System.out.print(root.data + " ");

            inorder(root.right);

            if (root.right != null)
                System.out.print(")");
        }
    }

    // Preorder traversal
    static void preorder(Node root) {

        if (root != null) {

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);

        }
    }

    // Postorder traversal
    static void postorder(Node root) {

        if (root != null) {

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");

        }
    }

    public static void main(String[] args) {

        // Expression Tree for (3+5)*(8-2)

        Node root = new Node("*");

        root.left = new Node("+");
        root.right = new Node("-");

        root.left.left = new Node("3");
        root.left.right = new Node("5");

        root.right.left = new Node("8");
        root.right.right = new Node("2");

        System.out.println("Postorder (Postfix):");
        postorder(root);

        System.out.println("\nInorder (Infix):");
        inorder(root);

        System.out.println("\nPreorder (Prefix):");
        preorder(root);


        // Expression Tree for a*b + c/d - e

        Node root2 = new Node("-");

        root2.left = new Node("+");
        root2.right = new Node("e");

        root2.left.left = new Node("*");
        root2.left.right = new Node("/");

        root2.left.left.left = new Node("a");
        root2.left.left.right = new Node("b");

        root2.left.right.left = new Node("c");
        root2.left.right.right = new Node("d");

        System.out.println("\n\nSecond Expression Traversals:");

        System.out.println("\nInorder:");
        inorder(root2);

        System.out.println("\nPreorder:");
        preorder(root2);

        System.out.println("\nPostorder:");
        postorder(root2);
    }
}
}
