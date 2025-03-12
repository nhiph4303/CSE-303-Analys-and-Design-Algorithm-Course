package Test2;

import java.util.*;

public class EISUBARRAY {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int max = 0;
        int min = 0;
        int maxPos = 0;
        int minNeg = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i] + max, nums[i]);
            maxPos = Math.max(max, maxPos);
            min = Math.min(nums[i] + min,nums[i]);
            minNeg = Math.min(min,minNeg);
        }
        System.out.println(Math.max((minNeg * -1), maxPos));
    }

}
