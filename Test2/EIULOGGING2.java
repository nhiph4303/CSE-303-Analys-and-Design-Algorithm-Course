package Test2;

import java.util.*;

public class EIULOGGING2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        long[] k = new long[n];
        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
        }
        if (n == 1) {
            System.out.println(Math.max(k[0], k[1]));
        }
        if (n == 2) {
            System.out.println(Math.max((Math.max(k[0], k[1])), k[2]));
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = Math.max(0, k[0]);
        dp[2] = Math.max(dp[1], k[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 3] + k[i - 1]);
        }

        System.out.println(dp[n]);
    }
}
