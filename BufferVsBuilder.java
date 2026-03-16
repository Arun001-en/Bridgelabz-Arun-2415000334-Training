public class FindSentence {
    public static void main(String[] args) {
        String[] sentences = {
            "Java is fun",
            "I love coding",
            "Searching algorithms are useful"
        };
        String target = "coding";
        
        System.out.println(findSentenceWithWord(sentences, target));
    }

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String s : sentences) {
            if (s.contains(word)) {
                return s;
            }
        }
        return "Not Found";
    }
}
