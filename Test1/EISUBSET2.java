package Test1;

import java.util.*;

public class EISUBSET2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> subset = new ArrayList<>();
        int count = 0;
        subset.add(0);

        for (int i = n - 1; i >= 0; i--) {
            int size = subset.size();
            for (int j = 0; j < size; j++) {
                int a = nums[i] + subset.get(j);
                if (a == k) {
                    count++;
                }
                subset.add(a);
            }
        }

        System.out.println(count);
    }
}
