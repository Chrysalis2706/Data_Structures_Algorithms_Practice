package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class First_Unique_Character {
    public static int firstUniqChar(String s) {

        if (s.length() == 1) return 0;

        int[] freq = new int[26];
        Queue<Character> charque = new LinkedList<>();
        int index = -1;

        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            charque.add(ch);
            freq[ch-'a']++;
            while (!charque.isEmpty() && freq[charque.peek()-'a']>1){
                charque.remove();
            }
            if (charque.isEmpty()){
                index = -1;
            }else{
                index = s.indexOf(charque.peek());
            }
        }

        return index;
    }


    public static void main(String[] args) {
        String str1 = "leetcode";
        String str2 = "loveleetcode";
        String str3 = "aabb";
        String str4 = "aabccxb";
        System.out.println(firstUniqChar(str1));
        System.out.println(firstUniqChar(str2));
        System.out.println(firstUniqChar(str3));
        System.out.println(firstUniqChar(str4));
    }
}
