import java.util.*;
public class basics { // class name same as file name

    public static int factorial (int n){
        if (n==1 || n ==0) {
            return  1;
        }

        int fact = 1;
        while (n >0){
            fact = fact * n;
            n--;
        }

        return  fact;
    }


    public static void main (String args[]){


        // output in Java
        System.out.print("Hello World!\n");

        // variables in java
//        int a;
//        a = 10;
//        System.out.println(a);

        // sum of a & b
//        a = 15;
//        int b = 35;
//        int sum;
//        sum = a + b;
//        System.out.println(sum);

        // next line usage
        Scanner sc = new Scanner(System.in);
//        String str = sc.next(); // will print till space only
//        System.out.println(str);
//        String str1 = sc.nextLine();
//        System.out.println(str1); // will print whole string

//        // area of circle
//        System.out.println("area of circle \nEnter radius : ");
//        float radius = sc.nextFloat();
//        float area = 3.14f * radius * radius;
//        System.out.println(area);

        // type casting
        int marks = (int)99.95f;
        System.out.println(marks);
//
//        float num = sc.nextFloat();
//        int num2 = (int)num; // float converted to int
//        System.out.println(num2);

//        // Question 3 : variables and data types
//        System.out.println("Enter Price of pencil");
//        float cost_pencil  = sc.nextFloat();
//        System.out.println("Enter Price of pen");
//        float cost_pen = sc.nextFloat();
//        System.out.println("Enter Price of eraser");
//        float cost_eraser = sc.nextFloat();
//        System.out.print("Total bill cost : ");
//        float bill = cost_eraser + cost_pen + cost_pencil;
//        System.out.println(bill);
//        System.out.println("Bill with 18% GST ");
//        float total_bill = bill + (bill * 0.18f);
//        System.out.print(total_bill);

        // Unary operator
        int num1 = 10;
        int num2 = --num1; // value changes then stored
        System.out.println(num1 + " " + num2); // 9 9

        num1 = 10;
        num2 = num1--; // value stored then changes
        System.out.println(num1 + " " + num2); // 9 10

        // Logical operator
        System.out.println( (12>10) && (11>8) ); // true
        System.out.println( (12>10) && (11>18) ); // false
        System.out.println( (12>10) || (11>18) ); // true
        System.out.println(!(12>10)); // true -> false

        int x = 9, y =12, a =2, b = 4, c = 6;
        int exp = 4/3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b*y);
        System.out.println(exp);

        // Conditional Statements
        // largest of three numbers

//        int n1 = sc.nextInt();
//        int n2 = sc.nextInt();
//        int n3 = sc.nextInt();
//
//        if (n1>=n2 && n1>=n3) System.out.println("larger is n1 = " + n1);
//        else if (n2>=n3) System.out.println("larger is n2 = " + n2);
//        else System.out.println("larger is n3 = " + n3);

        // Print reverse of a number

        int number = 10899;
        for (int i=1;i<=5;i++){
            int last_digit = number%10;
            System.out.print(last_digit);
            number = number / 10;
        }

        System.out.println("\n");

        // prime or not
//        int pnum = sc.nextByte();
//        boolean is_Prime = true;
//        if (pnum==1) is_Prime = false;
//
//        c = 2;
//        while (c*c <= pnum){
//            if (pnum%c==0) is_Prime = false;
//            c++;
//        }
//
//        System.out.println((is_Prime) ? pnum + " is Prime" : pnum + " is Not Prime");

//        int fnum = sc.nextInt();
//        System.out.println(factorial(fnum));

        for (int i=0;i<5;i++){
            System.out.println(i + " Hello");
            i += 2;
        }
    }

}