import java.util.Arrays;
import java.util.Locale;

public class Strings_anagrams {
    public static boolean isAnagram(String str1, String str2){
        boolean b = false;
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();


        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (arr1.length == arr2.length){
            int count = 0;
            for (int i=0; i<arr1.length; i++){
                if (arr1[i]==arr2[i]){
                    count++;
                }
            }
            if (count == arr1.length){
                b = true;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        String str1 = "Earth";
        String str2 = "heart";
        System.out.println(isAnagram(str1, str2));
    }
}
