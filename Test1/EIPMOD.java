package Test1;

import java.util.*;

public class EIPMOD {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long x = sc.nextLong();
        long n = sc.nextLong();
        long k = sc.nextLong();
        if (n == 0) {
            System.out.println(1 % k);
        } else {
            long ans = 1;
            x = x % k;

            while (n > 0) {
                if (n % 2 == 1) {
                    ans = (ans * x) % k;
                }

                n /= 2;
                x = (x * x) % k;
            }

            System.out.println(ans);
        }
    }
}
