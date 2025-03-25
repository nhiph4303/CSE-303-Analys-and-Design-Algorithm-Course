package Final;

import java.util.*;

public class EISUBSET2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(0);

        for (int i = n - 1; i >= 0; i--) {
            int size = subset.size();

            for (int j = 0; j < size; j++) {
                int sum = arr[i] + subset.get(j);

                if (sum == k){
                    count++;
                }
                subset.add(sum);
            }
        }

        System.out.println(count);

    }
}
