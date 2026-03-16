import java.util.ArrayList;
import java.util.List;

class FileNode {
    String name;
    boolean isFolder;
    int size; // in KB
    List<FileNode> children;

    public FileNode(String name, int size) {
        this.name = name;
        this.isFolder = false;
        this.size = size;
        this.children = null;
    }

    public FileNode(String name) {
        this.name = name;
        this.isFolder = true;
        this.size = 0;
        this.children = new ArrayList<>();
    }

    public void addChild(FileNode child) {
        this.children.add(child);
    }
}

public class DirectorySizeCalculator {
    public static void main(String[] args) {
        // Constructing the directory structure from the problem
        FileNode root = new FileNode("project");
        
        FileNode src = new FileNode("src");
        src.addChild(new FileNode("main.java", 100));
        src.addChild(new FileNode("utils.java", 50));
        
        FileNode docs = new FileNode("docs");
        docs.addChild(new FileNode("readme.txt", 10));
        FileNode guides = new FileNode("guides");
        guides.addChild(new FileNode("setup.pdf", 200));
        docs.addChild(guides);
        
        root.addChild(src);
        root.addChild(docs);
        root.addChild(new FileNode("config.xml", 20));

        System.out.println("Calculating total size for: " + root.name);
        int totalSize = calculateTotalSize(root);
        System.out.println("Total Directory Size: " + totalSize + " KB");
    }

    public static int calculateTotalSize(FileNode node) {
        // Base Case: If it is a file, return its size
        if (!node.isFolder) {
            return node.size;
        }

        // Recursive Case: It is a folder, sum up sizes of all children
        int total = 0;
        for (FileNode child : node.children) {
            total += calculateTotalSize(child);
        }
        return total;
    }
}
