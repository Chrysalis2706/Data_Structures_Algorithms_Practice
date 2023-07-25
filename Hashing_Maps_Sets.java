package Hashing;

import java.util.HashMap;
import java.util.Set;

public class Hashing_Maps_Sets {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Naruto", 2);
        hm.put("Attack on titan", 4);
        hm.put("Demon slayer", 4);
        hm.put("Noragami", 2);

        System.out.println(hm); //UNORDERED

        //Iteration
        Set<String> key = hm.keySet();
        System.out.println(key); // prints all keys

        for (String k : key){
            System.out.println("Anime name " + k + " has " + hm.get(k) + " seasons");
        }

    }
}
