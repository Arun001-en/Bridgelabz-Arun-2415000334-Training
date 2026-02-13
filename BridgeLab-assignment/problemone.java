import java.io.File;

public class problemone{

    public static long getDirectorySize(File file) {
        if (file.isFile()) {
            return file.length();
        }

        long size = 0;
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                size += getDirectorySize(f);
            }
        }

        return size;
    }

    public static void main(String[] args) {
        File folder = new File("path_to_directory");
        long totalSize = getDirectorySize(folder);
        System.out.println(totalSize);
    }
}
