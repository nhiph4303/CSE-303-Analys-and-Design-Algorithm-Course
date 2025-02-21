package Test1;

import java.util.*;

public class EIUGIFTS {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long money = sc.nextLong();

        int[] valueGift = new int[n];
        for (int i = 0; i < n; i++) {
            valueGift[i] = sc.nextInt();
        }
        Arrays.sort(valueGift);

        long maxTotal = -1;
        int minDif = Integer.MAX_VALUE;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            long total = valueGift[left] + valueGift[right];
            int dif = valueGift[right] - valueGift[left];

            if (total <= money) {
                if (total > maxTotal || (total == maxTotal && dif < minDif)) {
                    maxTotal = total;
                    minDif = dif;
                }
                left++;
            } else {
                right--;
            }
        }

        if (maxTotal == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(maxTotal + " " + minDif);
        }

    }
}
