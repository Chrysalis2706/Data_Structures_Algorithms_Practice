import javax.swing.*;
public class Patterns {

    public static void hollow_rectangle(int rows , int cols){
        for (int i =1; i<=rows; i++){
            for (int j =1; j<=cols; j++){
                // at cell i,j
                if (i== 1 || i == rows ||  j ==1 || j == cols){ // condition for boundaries
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println(); // next line
        }
    }

    public static void inverted_half_pyramid(int rows, int cols){
        for (int i =1; i<=rows; i++){
            for (int j=1; j<=rows-i;j++){
                // for printing white spaces
                System.out.print("  ");
            }
            for (int j=1; j<=i; j++){
                // for printing stars
                System.out.print("* ");
            }

            System.out.println();
        }
    }


    public static void inverted_half_pyramid_numbers(int n){
        for (int i=0; i<n; i++){
            for (int j=1 ; j<=n-i; j++){
                // to print numbers from 1 to n-i
                System.out.print(j + " ");
            }
            for (int j=1; j<=i; j++){
                // to print spaces in each line
                System.out.print("  ");
            }
            System.out.println();
        }
    }


    public static void floyds_triangle(int n){
        int counter = 1;
        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; j++){
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }


    public static void zero_one_triangle(int n){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; j++){
                if ((i+j)%2 == 0) {
                    System.out.print("1 ");
                }else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly_pattern(int n){
        for (int i = 1; i<=n; i++){
            //1st half

            // stars = i
            for (int j=1; j<=i; j++){
                System.out.print("* ");
            }

            // spaces = 2*(n-i)
            for (int j=1; j<=2*(n-i); j++){
                System.out.print("  ");
            }

            // stars = i
            for (int j=1; j<=i; j++){
                System.out.print("* ");
            }

            System.out.println();

        }

        //2nd Half

        for (int i=n ; i>=1; i--){

            // stars = i
            for (int j=1; j<=i; j++){
                System.out.print("* ");
            }

            // spaces = 2*(n-i)
            for (int j=1; j<=2*(n-i); j++){
                System.out.print("  ");
            }

            // stars = i
            for (int j=1; j<=i; j++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void solid_rhombus(int n){
        for (int i=1; i<=n; i++){
            // print spaces = n-i
            for (int j=1; j<=n-i; j++){
                System.out.print("  ");
            }

            // printing stars = n
            for (int j=1; j<=n; j++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void hollow_rhombus(int n){
        for (int i=1; i<=n; i++){

            // spaces : n-i
            for (int j=1; j<=(n-i); j++){
                System.out.print("  ");
            }

            // stars = boundaries condition
            for (int j=1; j<=n; j++){
                if (i==1 || j ==1 || i==n || j==n){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public static void diamond(int n){
        for (int i=1; i<=n; i++){
            // spaces : n-i
            for (int j=1; j<=n-i; j++){
                System.out.print("  ");
            }

            // stars = i
            for (int j=1; j<=2*i-1; j++){
                System.out.print("* ");
            }

            System.out.println();
        }

        // 2nd half
        for (int i=n ; i>=1; i--){
            // spaces : n-i
            for (int j=1; j<=n-i; j++){
                System.out.print("  ");
            }

            // stars = i
            for (int j=1; j<=2*i-1; j++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }



    public static void main(String[] args) {

        System.out.println("1. Star Pattern\n");

        for (int line = 1; line <= 10; line++){
            for (int no_of_stars = 1; no_of_stars<=line; no_of_stars++){
                System.out.print("* ");
            }
            System.out.println();
        }


        System.out.println("\n2.Inverted Pyramid\n");

        for (int i=1; i<=10; i++){
            for (int j=10-i+1; j>=1; j--){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n3.Half number Pyramid\n");

        for (int i=1;i<=10; i++){
            for (int j=1; j<=i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }


        System.out.println("\n4.Alphabet Pyramid\n");
        char ch = 'A';
        for (int i=1; i<=5; i++){
            for (int j=1; j<=i; j++){
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }


        System.out.println("\n5.Hollow Rectangle\n");
        hollow_rectangle(4, 5);

        System.out.println("\n6.Inverted & Rotated Half Pyramid\n");
        inverted_half_pyramid(4, 4);

        System.out.println("\n7.Inverted Half Pyramid with numbers \n");
        inverted_half_pyramid_numbers(5);

        System.out.println("\n8.Floyd's Triangle\n");
        floyds_triangle(5);

        System.out.println("\n9.0-1 Triangle\n");
        zero_one_triangle(5);

        System.out.println("\n10.Butterfly pattern\n");
        butterfly_pattern(4);

        System.out.println("\n11.Solid Rhombus\n");
        solid_rhombus(5);

        System.out.println("\n12.Hollow Rhombus\n");
        hollow_rhombus(5);

        System.out.println("\n13.Diamond\n");
        diamond(5);






    }
}
