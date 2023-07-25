public class String_compression {

    public static void compress_string(String s){
        String ans = "";
        for (int i=0; i<s.length(); i++){
            int count = 1;
            while (i < s.length()-1  && s.charAt(i)==s.charAt(i+1)){
                count++;
                i++;
            }
            ans += s.charAt(i);
            if (count>1) ans += count;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String str = "aaabbccccdd";
        compress_string(str);

    }

}
