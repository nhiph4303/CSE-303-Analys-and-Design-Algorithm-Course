package Test1;

import java.util.*;

public class EIDIVIDE {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        long n = sc.nextLong();
        long left = sc.nextLong();
        long right = sc.nextLong();

        long maxLenght = (long) (Math.log(n) / Math.log(2));
        if (Math.pow(2, maxLenght) > n) {
            maxLenght--;
        }
        long ans = 0;
        while (maxLenght >= 0) {
            if (n % 2 == 1) {
                ans += check(maxLenght, left, right);
            }
            maxLenght--;
            n /= 2;
        }
        System.out.println(ans);

    }

    static long check(long level, long left, long right) {
        long maxLeft = (long) Math.ceil((left - Math.pow(2, level)) / Math.pow(2, level + 1));
        long maxRight = (long) Math.floor((right - Math.pow(2, level)) / Math.pow(2, level + 1));

        if (maxLeft > maxRight) {
            return 0;
        }

        return maxRight - maxLeft + 1;
    }

}