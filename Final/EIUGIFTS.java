package Final;

import java.util.*;

public class EIUGIFTS {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long money = sc.nextLong();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        Arrays.sort(prices);

        // 10 40 50 50 60
        long maxTotal = -1;
        int minDiff = Integer.MAX_VALUE;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int total = prices[left] + prices[right];
            int diff = prices[right] - prices[left];

            if (total <= money) {
                if (total > maxTotal || (total == maxTotal && diff < minDiff)) {
                    maxTotal = total;
                    minDiff = diff;
                }
                left++;
            } else {
                right--;
            }
        }

        if (maxTotal == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(maxTotal + " " + minDiff);
        }
    }
}
