import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("user_output.txt")) {
            
            System.out.println("Enter text (type 'exit' to stop):");
            String line;
            
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + System.lineSeparator());
            }
            System.out.println("Data written to user_output.txt");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
