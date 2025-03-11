package Test2;

import java.util.*;

public class LOGGING {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        long[] k = new long[n];
        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = Math.max(0, k[0]);

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + k[i-1]);
        }

        System.out.println(dp[n]);
    }
}
