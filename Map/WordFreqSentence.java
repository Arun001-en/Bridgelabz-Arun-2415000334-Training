import java.util.*;

public class WordFreqSentence {
    public static void main(String[] args) {
        String s = "Java is fun and Java is powerful";

        s = s.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = s.split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);

        System.out.println(map);
    }
}
