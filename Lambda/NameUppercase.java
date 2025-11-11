import java.util.*;
import java.util.stream.Collectors;

public class NameUppercase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ayush", "Rohan", "Priya");

        List<String> upperNames = names.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());

        System.out.println(upperNames);
    }
}

