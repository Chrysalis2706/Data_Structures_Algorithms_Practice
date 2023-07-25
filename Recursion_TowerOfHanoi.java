public class Recursion_TowerOfHanoi {

    public static void towerOfHanoi(int n, String source, String helper, String desitination){

        // base case
        if (n==0) return;

        // pehle n-1 disk ko uthakr helper prr rakhdo
        towerOfHanoi(n-1, source, desitination, helper);
        // fir bachi hui ek disk ko source sai destination prr rakh do
        System.out.println("Placing disk " + n + " from " + source + " to " + desitination);
        // fir helper par bachi n-1 disk ko uthakr destination rkha do
        towerOfHanoi(n-1, helper, source, desitination);

    }

    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, "Source", "Helper", "Destination");
    }
}
