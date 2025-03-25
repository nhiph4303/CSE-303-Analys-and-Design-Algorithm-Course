package Final;

import java.util.*;

public class EISUBARRAY {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        int min = 0;
        int maxSum = 0;
        int minSum = 0;

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            max = Math.max(num, num + max);
            maxSum = Math.max(max, maxSum);
            min = Math.min(num, min + num);
            minSum = Math.min(min, minSum);
        }

        System.out.println(Math.max((minSum * -1), maxSum));

    }
}
