package Final;

import java.util.*;

public class EIPAIR {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            Map<Integer, Integer> gift = new HashMap<>();

            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int price = sc.nextInt();
                gift.put(price, gift.getOrDefault(price, 0) + 1);
            }

            long ways = 0;

            for (int p : gift.values()) {
                if (p > 1) {
                    ways += (long) p * (p - 1) / 2;
                }
            }

            sb.append(ways + "\n");
        }

        System.out.println(sb);
    }
}
