import java.util.Locale;

public class Recursion_DuplicateInString {

    public static void removeDuplicates(int index, String str, StringBuilder sb, boolean[] map){
        // Base case
        if (index == str.length()){
            System.out.println(sb);
            return;
        }
        char curr = str.charAt(index);
        //Kaam
        if (map[curr-'a']==true){
            //duplicates found
            removeDuplicates(index+1, str, sb, map);
        }else {
            // not found
            map[curr - 'a'] = true;
            removeDuplicates(index + 1, str, sb.append(curr), map);

        }
    }

    public static void main(String[] args) {
        String str = "HellolllParrrthhdfgfdgttth";
        removeDuplicates(0, str.toLowerCase(), new StringBuilder(""), new boolean[26]);
    }
}
