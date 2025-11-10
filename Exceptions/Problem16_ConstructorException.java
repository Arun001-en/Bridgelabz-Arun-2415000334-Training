import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class FileHandler {
    public FileHandler(String fileName) throws IOException {
        System.out.println("Attempting to open file: " + fileName);
        FileReader reader = new FileReader(fileName);
        System.out.println("File opened successfully.");
        reader.close();
    }
}

public class Problem16_ConstructorException {
    public static void main(String[] args) {
        try {
            System.out.println("Attempting to create FileHandler...");
            FileHandler fh = new FileHandler("missing_file.txt");
            System.out.println("FileHandler object created.");
        } catch (IOException e) {
            System.out.println("Failed to create FileHandler object.");
            System.out.println("Caught in main: " + e.getMessage());
        }
    }
}
