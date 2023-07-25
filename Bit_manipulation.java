public class Bit_manipulation {

    public static String oddOrEven(int n){
        int bitmask = 1;
        if ((n&bitmask) == 0){
            return n + " is Even";
        }

        return n + " is Odd";
    }

    public static int get_ith_bit(int n, int i){
        int bitmask = 1<<i;  // Left shift till the position
        if ((n&bitmask) == 0){
            return 0;
        }
        return 1;
    }

    public static int set_ith_bit(int n, int i){
        int bitmask = 1<<i;
        return n | bitmask;
    }

    public static int clear_ith_bit(int n, int i){
        int bitmask = 1<<i;
        return n & ~(bitmask);
    }

    // Update the ith bit to newbit : 1 or 0
    public static void update_ith_bit(int n, int i, int newbit){
        if (newbit == 1){
            clear_ith_bit(n, i);
        }else {
            set_ith_bit(n,i);
        }
    }

    // clear last i bits
    public static int clear_last_ith_bits(int n, int i){
        int bitmask = (~0)<<i;
        return n & bitmask;
    }

    // Check if the number is power of 2
    public static boolean power_of_two(int n){
        return ((n&(n-1)) == 0);
    }

    // Count set bits
    public static int count_set_bit(int n){
        int count = 0;
        while (n>0){
            if ((n&1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    // Fast Exponentiation : a^n
    public static int fast_exponent(int a, int n){
        int ans = 1;
        while (n>0){
            if ((n&1)!=0){
                ans = ans * a;
            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }



    public static void main(String[] args) {
        String ans = oddOrEven(11);
        System.out.println(ans);
        ans = oddOrEven(12);
        System.out.println(ans);

        int position = get_ith_bit(10, 3);
        System.out.println(position);

        int res = set_ith_bit(10, 2);
        System.out.println(res);

        System.out.println(clear_ith_bit(10, 3));

        System.out.println(power_of_two(6));

        System.out.println(count_set_bit(1));

        System.out.println(fast_exponent(3, 3));

    }
}
