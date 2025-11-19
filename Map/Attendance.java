import java.util.*;

public class Attendance {
    public static void main(String[] args) {
        Map<String, Integer> att = new HashMap<>();

        String[] students = {"Arun","Rahul","Neha","Ram","Simran"};
        for (String s : students) att.put(s, 0);

        String[][] days = {
            {"Arun","Neha","Ram"},
            {"Arun","Simran"},
            {"Rahul","Neha"},
            {"Arun","Neha","Simran"},
            {"Ram","Neha"}
        };

        for (String[] present : days)
            for (String p : present)
                att.put(p, att.get(p) + 1);

        System.out.println("Under 3 days:");
        for (String s : att.keySet())
            if (att.get(s) < 3)
                System.out.println(s + " -> " + att.get(s));
    }
}
