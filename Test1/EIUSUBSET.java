package Test1;

import java.util.*;

public class EIUSUBSET {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        String[] nums = new String[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.next();
        }

        int count = 0;
        ArrayList<String> subset = new ArrayList<>();
        subset.add(" ");

        for (int i = n - 1; i >=0; i--) {
            int sizeSubset = subset.size();

            for (int j = 0; j < sizeSubset; j++) {
                String a = nums[i] + " " + subset.get(j);
                subset.add(a);
                count++;

                sb.append(a + "\n");
            }
        }

        System.out.println(count + "\n" + sb.toString());
    }
}
