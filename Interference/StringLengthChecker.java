import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {
        
        int limit = 20;
        Function<String, Integer> getLength = str -> str.length();

        String[] messages = {
            "Hello, world!",
            "This message is definitely too long.",
            "Short msg"
        };

        for (String msg : messages) {
            int length = getLength.apply(msg);
            if (length > limit) {
                System.out.println("Message exceeds limit (" + length + " chars): " + msg);
            } else {
                System.out.println("Message is within limit (" + length + " chars): " + msg);
            }
        }
    }
}
