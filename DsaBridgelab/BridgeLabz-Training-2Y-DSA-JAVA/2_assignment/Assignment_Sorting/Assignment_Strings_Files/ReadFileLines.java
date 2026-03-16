import java.io.*;

public class ReadFileLines {
    public static void main(String[] args) {
        // Reads from the sample file created by the script
        File file = new File("../sample_data.txt"); 
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
