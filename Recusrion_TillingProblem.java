public class Recusrion_TillingProblem {

    public static int tilling_problem(int n){

        // Base cases
        if (n==0 || n==1) return 1;
        if (n==2) return 2;

        // vertical choices
        int ver_choice = tilling_problem(n-1);

        // horizontal choices
        int hori_choice = tilling_problem(n-2);

        return ver_choice + hori_choice;
    }

    public static void main (String[] args){

        System.out.println(tilling_problem(10));
    }
}
