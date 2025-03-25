package Final;

import java.util.*;

public class EIJUMP {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(color[0], 0);

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (map.containsKey(color[i])) {
                dp[i] = Math.min(dp[i], map.get(color[i]) + 1);
            }
            map.put(color[i], dp[i]);
        }

        System.out.println(dp[n - 1]);
    }
}
