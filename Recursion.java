import java.security.spec.RSAOtherPrimeInfo;

public class Recursion {


    public static void printdec(int n){

        if (n==1){
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printdec(n-1);
    }

    public static void printInc(int n){

        if (n==1){
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }


    public static int factorial(int n){
        if (n==0){
            return 1;
        }
        int ans = n * factorial(n-1);
        return ans;
    }

    public static int sumN_Natural(int n){
        if (n==1){
            return 1;
        }
        int sum = n + sumN_Natural(n-1);
        return sum;
    }


    public static int nth_fibonacci(int n){
        if (n==1 || n==0){
            return n;
        }
        int ans = nth_fibonacci(n-1) + nth_fibonacci(n-2);
        return ans;
    }

    public static void fibonacci(int n){
        int n1=0,n2=1,n3,i,count=10;
        System.out.print(n1+" "+n2);

        for(i=2;i<count;++i)
        {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
    }

    public static int fibonacci_with_recursion(int n){
        if (n==1 || n==0){
            return n;
        }
        int ans = fibonacci_with_recursion(n-1) + fibonacci_with_recursion(n-2);
        return ans;
    }



    public static boolean isSortedArray(int[] arr, int i){

        if (i==arr.length-1){
            return true;
        }
        if (arr[i] > arr[i+1]){
            return false;
        }
        return isSortedArray(arr, i+1);
    }

    public static int first_Occurence(int[] arr, int key, int i){
        if (i == arr.length) return -1;
        if (arr[i] == key) return i;
        return first_Occurence(arr, key, i+1);
    }


    public static int last_Occurence(int[] arr, int key, int i){
        if (i == arr.length) return -1;

        int index = last_Occurence(arr, key, i+1);
        if (index == -1 && arr[i] == key){
            return i;
        }

        return index;
    }

    public static int pow(int x, int n){
        if (n==0) return 1;
        int xn = x * pow(x, n-1);
        return xn;
    }

    public static int pow_optimized(int x, int n){
        if (n==0) return 1;
        int a = pow(x, n/2);
        if (n%2 == 0){
            return a*a;
        }else {
            return x * a * a;
        }
//        if (n%2 == 0) return pow(x, n/2) * pow(x, n/2); // do not call twice as time complexity is still the same
//        else return x * pow(x, n/2) * pow(x, n/2);  // do not call twice as time complexity is still the same
    }

    public static int facto(int n){
        if (n==0 || n==1) return 1;
        return n * facto(n-1);

    }


    public static void main(String[] args) {

        printInc(10);
        System.out.println();
        printdec(10);
        System.out.println("\n" + factorial(5));
        System.out.println(sumN_Natural(5));
        System.out.println(nth_fibonacci(5));
        fibonacci(10);
        System.out.println();

//        int n = 10;
//        System.out.print(0 + " " + 1);
//        fibonacci_with_recursion(n-2);

        int n = 10;
        for (int i=0; i<n; i++){
            System.out.print(fibonacci_with_recursion(i) + " ");
        }

        System.out.println();
        int[] arr = {1, 1, 2, 9};
        System.out.println(isSortedArray(arr,0));

        int[] nums = {8, 3, 6, 9, 5, 10, 2, 5, 3, 5};
        int index = first_Occurence(nums, 5, 0);
        System.out.println(index);

        int[] arr2 = {5, 2, 1, 2, 4, 2};

        System.out.println(last_Occurence(arr2, 2, 0));
        System.out.println(facto(3));

        System.out.println(pow(2,4));
        System.out.println(pow_optimized(2, 10));











    }
}
