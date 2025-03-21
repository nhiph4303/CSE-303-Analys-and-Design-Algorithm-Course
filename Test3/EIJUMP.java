package Test3;

import java.util.*;

public class EIJUMP {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(c[0], 0);

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (map.containsKey(c[i])) {
                dp[i] = Math.min(dp[i], map.get(c[i]) + 1);
            }
            map.put(c[i], dp[i]);
        }

        System.out.println(dp[n - 1]);

    }
}
