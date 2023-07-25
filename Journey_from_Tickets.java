package Hashing;
import java.text.BreakIterator;
import java.util.*;

public class Journey_from_Tickets {
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()){
            System.out.print(" --> " + tickets.get(start));
            start = tickets.get(start);
        }

    }

    private static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String tk : tickets.keySet()) {
            revMap.put(tickets.get(tk), tk);
        }

        // start point is which exist in tickets but not in rev, from hai but to nhi hai;
        for (String tk : tickets.keySet()){
            if (!revMap.containsKey(tk)){
                return tk;
            }
        }
        return null;
    }

}