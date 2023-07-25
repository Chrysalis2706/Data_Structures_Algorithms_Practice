public class BackTracking {

    public static void printArr(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");;
        }
        System.out.println();
    }

    public static void chnageArr(int[] arr, int i, int val){
        //Base case
        if (i==arr.length) {
            printArr(arr);
            return;
        }

        // recursion step
        arr[i] = val;
        chnageArr(arr, i+1, val+1);

        // Backtracking step
        arr[i] -= 2;
    }

    // Find all Subsets
    public static void findSubSets(String str, String ans, int i){
        // base case
        if (i==str.length()){
            if (ans.length()==0){
                System.out.print("null ");
            }else{
                System.out.print(ans + " ");
            }
            return;
        }

        // recursion call

        // yes choice
        findSubSets(str, ans+str.charAt(i), i+1);
        // no choice
        findSubSets(str, ans, i+1);
    }


    public static void find_permutations(String str, String ans){
        // base case
        if (str.length()==0){
            System.out.print(ans + " ");
            return;
        }

        // recursion call
        for (int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String new_string = str.substring(0, i) + str.substring(i+1, str.length()); // next boundary is not included
            find_permutations(new_string, ans+curr);
        }
    }


    public static void main(String[] args) {
//        int[] arr = new int[5];
//        chnageArr(arr, 0, 1);
//        printArr(arr);

//        findSubSets("abc", "", 0);

        find_permutations("abc", "");
    }
}
