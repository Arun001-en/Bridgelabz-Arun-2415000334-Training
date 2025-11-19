import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";

        text = text.toLowerCase().replaceAll("[^a-z ]", ""); // remove punctuation
        String[] words = text.split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        System.out.println(map);
    }
}
