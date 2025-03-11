package Test2;

import java.util.*;

public class EIUSUBSET {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<String> subset = new ArrayList<>();
        subset.add(" ");
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            int size = subset.size();

            for (int j = 0; j < size; j++) {
                String newEle = nums[i] + " " + subset.get(j);
                subset.add(newEle);
                count++;

                sb.append(newEle + "\n");
            }
        }

        System.out.println(count + "\n" + sb);
    }
}
