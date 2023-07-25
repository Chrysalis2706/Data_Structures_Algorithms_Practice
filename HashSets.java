package Hashing;
import java.util.*;

public class HashSets {
    public static void main(String[] args) {
        HashSet<String> hs= new HashSet();
        hs.add("1. Naruto");
        hs.add("2. DemonSlayer");
        hs.add("3. Attack on titan");
        hs.add("4. One Piece");

        Iterator it = hs.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("\nNot in Order\n");

        //2nd method
        for (String anime : hs){
            System.out.println(anime);
        }


        // Linked Hash Set
        LinkedHashSet<String> lhs= new LinkedHashSet<>();
        lhs.add("1. Naruto");
        lhs.add("2. DemonSlayer");
        lhs.add("3. Attack on titan");
        lhs.add("4. One Piece");

        System.out.println("\nOrdered Linked Hash Sets");

        Iterator lit = lhs.iterator();
        while (lit.hasNext()){
            System.out.println(lit.next());
        }
    }
}
