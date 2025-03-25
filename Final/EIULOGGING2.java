package Final;

import java.util.*;

public class EIULOGGING2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] k = new long[n];

        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
        }
        if (n == 1) {
            System.out.println(Math.max(0, k[0]));
            return;
        }
        if (n == 2) {
            System.out.println(Math.max(0, Math.max(k[0], k[1])));
            return;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = Math.max(0, k[0]);
        dp[2] = Math.max(0, dp[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 3] + k[i - 1]);
        }

        System.out.println(dp[n]);

    }
}
