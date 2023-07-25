public class Recursion_PracticeProblems {

    public static void all_occurences(int[] arr, int i, int key){
        if (i == arr.length) return;
        if (arr[i]==key) System.out.print(i + " ");
        all_occurences(arr, i+1, key);
    }

    public static void number_to_words(int n){
        if (n==0){
            return;
        }
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int last_digit = n%10;
        number_to_words(n/10);
        System.out.print(words[last_digit] + " ");
    }

    public static int string_length(String str){
        if (str.length() == 0) return 0;
        return string_length(str.substring(1)) + 1;
    }

    public static int same_char_at_beg_end(String str, int i, int j, int n){ //O(3^n)
        // Base cases
        if (n==1) return 1;
        if (n<=0) return 0;

        // AUB = A + B + A intersection B
        int res = same_char_at_beg_end(str, i+1, j, n-1) +
                same_char_at_beg_end(str, i, j-1, n-1) -
                same_char_at_beg_end(str, i+1, j-1, n-2);

        if (str.charAt(i)==str.charAt(j)) res++;
        return res;
    }

    public static int optimized_same_char(String str){ //0(n)
        int n = str.length();
        int ans = 0;
        int[] words = new int[26];
        for (int i=0; i<n; i++){
            words[str.charAt(i)-'a']++;
        }

        for (int i=0; i<words.length; i++){
            ans = ans + (words[i]*(words[i]+1))/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr=  {2, 4, 2, 5, 5, 2, 6, 6 ,3, 2};
        all_occurences(arr, 0,2);

        System.out.println();
        number_to_words(1987);
        System.out.println();

        String name = "Parth";
        System.out.println(string_length(name));

        String sample = "abcab";
        int res = same_char_at_beg_end(sample, 0, sample.length()-1, sample.length());
        System.out.println(res);
        System.out.println(optimized_same_char(sample));
    }

}
