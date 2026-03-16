import java.io.*;

public class CountWordInFile {
    public static void main(String[] args) {
        File file = new File("../sample_data.txt");
        String targetWord = "Hello";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            System.out.println("Occurrences of '" + targetWord + "': " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
