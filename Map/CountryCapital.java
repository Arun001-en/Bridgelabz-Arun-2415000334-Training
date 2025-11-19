import java.util.*;

public class CountryCapital {
    public static void main(String[] args) {
        Map<String,String> cc = new TreeMap<>();

        cc.put("India","Delhi");
        cc.put("USA","Washington");
        cc.put("UK","London");
        cc.put("Japan","Tokyo");
        cc.put("France","Paris");
        cc.put("China","Beijing");
        cc.put("Russia","Moscow");
        cc.put("Canada","Ottawa");

        // lookup
        String c = "Japan";
        System.out.println(cc.getOrDefault(c,"Unknown country"));

        // sorted print
        for (String k : cc.keySet())
            System.out.println(k + " -> " + cc.get(k));
    }
}
