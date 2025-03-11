package Test2;

import java.util.*;

public class EISUBSET2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> subset = new ArrayList<>();
        subset.add(0);
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            int size = subset.size();

            for (int j = 0; j < size; j++) {
                int newEle = nums[i] + subset.get(j);
                if (newEle == k){
                    count++;
                }
                subset.add(newEle);
            }
        }

        System.out.println(count);
    }

}
