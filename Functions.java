import java.util.Locale;
import java.util.Scanner;

public class Functions {

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static int factorial(int n){
        int fact = 1;
        while (n>0){
            fact = fact * n;
            n--;
        }

        return fact;
    }

    public static boolean isPrime(int n){
        if (n==2){
            return true;
        }
        for (int i =2;i<=Math.sqrt(n);i++){
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void prime_in_range(int r){
        for (int i =2; i<=r; i++){
            if (isPrime(i)){
                System.out.println(i);
            }
        }
    }

    public static int bintodec(int bin_num){
        int dec_num = 0;
        int pow = 0;

        while (bin_num > 0){
            int last_digit = bin_num % 10;
            dec_num = dec_num + (last_digit * (int)Math.pow(2,pow));
            bin_num = bin_num / 10;
            pow++;
        }

        return dec_num;
    }

    public static int dectobin(int dec_num){
        int bin_num = 0;
        int pow = 0;

        while (dec_num > 0){
            int rem = dec_num % 2;
            bin_num = bin_num + (rem * (int) Math.pow(10, pow));
            dec_num = dec_num / 2;
            pow++;
        }


        return bin_num;

    }

    public static void palindrome_number(int n){
        int check = 0;
        int original = n;
        while (n > 0){
            int r = n%10;
            check = (10*check) + r;
            n = n/10;
        }
        if (original == check){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    public static void isPalindromeString(String str){
        String original = str;
        String check = "";
        int len = str.length();
        int i = len-1;
        while (i >= 0){
            check = check + str.charAt(i);
            i--;
        }
        if (str.toLowerCase().equals(check.toLowerCase())){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    public static boolean isArmstrong(int n){
        int original  = n;
        int sum = 0;
        while (n > 0){
            int rem = n % 10;
            sum = sum + (int)Math.pow(rem,3);
            n = n/10;
        }

        if (sum == original) {
            return true;
        }else {
            return false;
        }
    }



    public static void main(String[] args) {
//        int x = 10;
//        int y = 20;
//        System.out.println("Actual value : " + x + " " + y);  // without "" in b/w prints 1020
//        swap(x,y);
//        System.out.println("After Swapping value : " + x + " " + y);

        // Due to Call by value in Java

//          Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number to find factorial : ");
//        int a = sc.nextInt();
//        System.out.println(factorial(a));

        // Prime or not using function
//        System.out.println("Check if numbers is prime or not\nEnter number : ");
//        int n = sc.nextInt();
//        boolean b = isPrime(n);
//        System.out.println((b) ? n + " is Prime" : n + " is Not Prime");

        // Prime in range
//        System.out.println("Enter till when you want to have prime numbers");
//        int n = sc.nextInt();
//        prime_in_range(n);


        // Binary to Decimal
//        int res = bintodec(101);
//        System.out.println(res);

        System.out.println(bintodec(101));

        // Decimal to Binary
        System.out.println(dectobin(5));

        // Palindrome Number
//        palindrome_number(132);
//        palindrome_number(1001);
//        palindrome_number(34543);

        // Palindrome String
        isPalindromeString("ADA");
        isPalindromeString("raDar");
        isPalindromeString("AdadsA");

        // Armstrong Number
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(154));













    }
}
