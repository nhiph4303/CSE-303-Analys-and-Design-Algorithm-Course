package Test2;

import java.util.*;

public class EIDIVIDE {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        long n = sc.nextInt();
        long l = sc.nextInt();
        long r = sc.nextInt();

        long maxLength = (long) (Math.log(n) / Math.log(2));
        if (Math.pow(2, maxLength) > n) {
            maxLength--;
        }
        long ans = 0;
        while (maxLength >= 0) {
            if (n % 2 == 1) {
                ans += check (maxLength,l,r);
            }
            maxLength--;
            n/=2;
        }

        System.out.println(ans);
    }

    static long check(long level, long left, long right) {
        long maxL = (long) Math.ceil((left - Math.pow(2, level)) / Math.pow(2, level + 1));
        long maxR = (long) Math.floor((right - Math.pow(2, level)) / Math.pow(2, level + 1));

        if (maxL > maxR) {
            return 0;
        }

        return maxR - maxL + 1;
    }
}
