import java.util.*;

public class Voting {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();

        String[] cast = {"A","B","A","C","A","B","C","A","B","A"};

        for (String c : cast)
            votes.put(c, votes.getOrDefault(c, 0) + 1);

        // print
        System.out.println(votes);

        // find winner
        String winner = "";
        int max = 0;

        for (String c : votes.keySet()) {
            if (votes.get(c) > max) {
                max = votes.get(c);
                winner = c;
            }
        }

        System.out.println("Winner = " + winner);
    }
}
