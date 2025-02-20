package Test1;

import java.util.*;

public class EISUBARRAY {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = 0;
        int min = 0;
        int posMaxSum = 0;
        int negMaxSum = 0;

        for (int i = 0; i < n; i++) {
            int a = nums[i];

            max = Math.max(a, max + a);
            posMaxSum = Math.max(posMaxSum, max);

            min = Math.min(a, min + a);
            negMaxSum = Math.min(negMaxSum, min);
        }

        System.out.println(Math.max(posMaxSum, -1 * negMaxSum));
    }
}
