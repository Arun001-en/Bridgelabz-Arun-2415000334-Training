public class problem2 {
    class TreeTraversal {

        // Node structure
        static class Node {
            String data;
            Node left, right;

            Node(String value) {
                data = value;
                left = right = null;
            }
        }

        // Preorder Traversal (Root → Left → Right)
        static void preorder(Node root) {
            if (root != null) {
                System.out.print(root.data + " ");
                preorder(root.left);
                preorder(root.right);
            }
        }

        // Inorder Traversal (Left → Root → Right)
        static void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
            }
        }

        // Postorder Traversal (Left → Right → Root)
        static void postorder(Node root) {
            if (root != null) {
                postorder(root.left);
                postorder(root.right);
                System.out.print(root.data + " ");
            }
        }

        public static void main(String[] args) {

            // Creating the tree structure
            Node root = new Node("root");

            root.left = new Node("home");
            root.right = new Node("var");

            root.left.left = new Node("user");
            root.left.right = new Node("docs");

            root.right.right = new Node("log");

            root.left.left.left = new Node("config");

            // Traversals
            System.out.println("Preorder Traversal:");
            preorder(root);

            System.out.println("\n\nInorder Traversal:");
            inorder(root);

            System.out.println("\n\nPostorder Traversal:");
            postorder(root);
        }
    }
}