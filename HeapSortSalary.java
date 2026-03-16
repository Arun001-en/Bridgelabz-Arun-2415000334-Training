import java.io.*;

public class BinaryToChar {
    public static void main(String[] args) {
        File file = new File("../sample_data.txt");

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
