public class Strings_in_Java {

    //1. Palindrome string
    public static boolean isPalindrome(String str){
        int n = str.length();
        for (int i=0; i<n/2; i++){
            if (str.charAt(i) != str.charAt(n-1-i)) return false;
        }
        return true;
    }

    // 2. Shortest path with direction string
    public static float shortestPath(String str){
        float path = 0;

        int x = 0, y = 0;
        for (int i=0; i<str.length(); i++){
            char dir = str.charAt(i);
            switch (dir){
                case 'N' : x++;
                break;
                case 'S' : x--;
                break;
                case 'E' : y++;
                break;
                case 'W' : y--;
                break;
                default: continue;
            }
        }

        int x2 = x*x;
        int y2 = y*y;

        path = (float)Math.sqrt(x2+y2);

        return path;
    }

    // 3. Largest Lexicographical string
    public static void largest_str(String[] arr){
        String largest = arr[0];
        for (int i=0; i<arr.length; i++){
            if (largest.compareToIgnoreCase(arr[i]) < 0){
                largest = arr[i];
            }
        }
        System.out.println(largest);
    }

    // 4. Convert First word to Upper case
    public static String first_word_upper_case(String str){

        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i=1; i<str.length(); i++){
            if (str.charAt(i)== ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    // Practice Question : 1
    public static void vowels(String str){
        int a = 0, e = 0, i = 0, o =0, u = 0;
        for (int k=0; k<str.length(); k++){
            char ch = str.charAt(k);
            switch (ch){
                case 'a' : a++;
                break;
                case 'e' : e++;
                break;
                case 'i' : i++;
                break;
                case 'o' : o++;
                break;
                case 'u' : u++;
                break;
                default: continue;
            }
        }
        System.out.println("Numbers of as " + a + "\n"+ "Numbers of es " + e + "\n"
                + "Numbers of is " + i + "\n" + "Numbers of os " + o + "\n" + "Numbers of us " + u + "\n");
    }



    public static void main(String[] args) {
        String str = " p ";
        System.out.println(str.length());
        String palindrome = "noon";
        System.out.println(isPalindrome(palindrome));

        String path = "WNEENESENNN";
        float ans = shortestPath(path);
        System.out.println(ans);

        String[] fruits = {"apple", "mango", "koi_sa_fruit" };
        largest_str(fruits);

        String sense = "hey , i am pArth";
        String res = first_word_upper_case(sense);
        System.out.println(res);

        String vowels = "aassdseeidddsdooooou";
        vowels(vowels);
    }
}
