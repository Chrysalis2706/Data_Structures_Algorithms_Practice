public class Recursion_FriendsPairing {

    public static int pairing(int n){
        // base case
        if (n==1) return 1;
        if (n==2) return 2;

        // single
        int single = pairing(n-1);

        // paired
        int pairs = /* number of pairs*/pairing(n-2)     *    /*total choices*/ (n-1);

        return pairs + single;
    }

    public static void main(String[] args) {
        System.out.println(pairing(5));
    }
}
