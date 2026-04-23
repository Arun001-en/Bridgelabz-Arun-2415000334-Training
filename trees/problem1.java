public class problem1 {
    class OrgChartTree {

    // Node structure
    static class Node {
        String data;
        Node left, right;

        Node(String value) {
            data = value;
            left = right = null;
        }
    }

    // Function to print leaf nodes
    static void printLeafNodes(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            return;
        }

        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    // Function to find height of tree
    static int height(Node root) {
        if (root == null)
            return -1;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Function to find depth of a node
    static int findDepth(Node root, String target, int depth) {

        if (root == null)
            return -1;

        if (root.data.equals(target))
            return depth;

        int left = findDepth(root.left, target, depth + 1);

        if (left != -1)
            return left;

        return findDepth(root.right, target, depth + 1);
    }

    // Function to print ancestors
    static boolean printAncestors(Node root, String target) {

        if (root == null)
            return false;

        if (root.data.equals(target))
            return true;

        if (printAncestors(root.left, target)
                || printAncestors(root.right, target)) {

            System.out.print(root.data + " ");
            return true;
        }

        return false;
    }

    // Function to find degree of node
    static int degree(Node node) {
        int count = 0;

        if (node.left != null)
            count++;

        if (node.right != null)
            count++;

        return count;
    }

    public static void main(String[] args) {

        // Create organizational tree
        Node CEO = new Node("CEO");

        CEO.left = new Node("CTO");
        CEO.right = new Node("CFO");

        CEO.left.left = new Node("Dev Lead");
        CEO.left.right = new Node("HR");

        CEO.left.left.left = new Node("Dev1");
        CEO.left.left.right = new Node("Dev2");

        // Print Leaf Nodes
        System.out.print("Leaf Nodes: ");
        printLeafNodes(CEO);

        // Height of Tree
        System.out.println("\nHeight of Tree: " + height(CEO));

        // Depth of Dev Lead
        System.out.println("Depth of Dev Lead: "
                + findDepth(CEO, "Dev Lead", 0));

        // Ancestors of Dev1
        System.out.print("Ancestors of Dev1: ");
        printAncestors(CEO, "Dev1");

        // Degree of CTO node
        System.out.println("\nDegree of CTO: "
                + degree(CEO.left));
    }
}
}