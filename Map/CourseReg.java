import java.util.*;

public class CourseReg {
    public static void main(String[] args) {
        Map<String,Integer> reg = new HashMap<>();

        reg.put("CS101", 40);
        reg.put("CS102", 4);
        reg.put("CS103", 60);
        reg.put("CS104", 2);
        reg.put("CS105", 55);

        // add students
        reg.put("CS101", reg.get("CS101") + 5);

        // drop students
        reg.put("CS102", Math.max(0, reg.get("CS102") - 3));

        System.out.println("Near Full (>=50):");
        for (String c : reg.keySet())
            if (reg.get(c) >= 50)
                System.out.println(c);

        System.out.println("Under-subscribed (<5):");
        for (String c : reg.keySet())
            if (reg.get(c) < 5)
                System.out.println(c);
    }
}
