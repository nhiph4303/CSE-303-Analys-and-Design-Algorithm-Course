package Final;

import java.util.*;

public class EIULOGGING3 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int MOD = 1000000007;

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] k = new long[n];

        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
        }

        long[] dp = new long[n + 1];
        long[] ways = new long[n + 1];

        dp[0] = 0;
        dp[1] = Math.max(0, k[0]);
        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (dp[i - 1] > dp[i - 2] + k[i - 1]) {
                dp[i] = dp[i - 1];
                ways[i] = ways[i - 1];
            } else if (dp[i - 1] < dp[i - 2] + k[i - 1]) {
                dp[i] = dp[i - 2] + k[i - 1];
                ways[i] = ways[i - 2];
            } else {
                dp[i] = dp[i - 1];
                ways[i] = (ways[i - 1] + ways[i - 2]) % MOD;
            }
        }

        System.out.println(dp[n] + " " + ways[n]);

    }
}
