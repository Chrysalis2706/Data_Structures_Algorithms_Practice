public class Recursion_BinaryStringProblem {

    public static void bString_Problem(String str, int n, int lastPlace){
        // base case
        if (n==0) {
            System.out.print(str + "  ");
            return;
        }

        // kaam

        // 0 ko betha krr last place zero bna diya
        bString_Problem(str+"0", n-1, 0);

        // 1 ko tab he bethana hai jb last place prr 0 ho
        if (lastPlace==0) bString_Problem(str+"1", n-1, 1); // 1 ko betha krr last place 1 bna do
    }

    public static void main(String[] args) {
        bString_Problem("", 3, 0);
    }
}
