package Final;

import java.util.*;

public class EIUSUBSET {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        int count = 0;
        List<String> subset = new ArrayList<>();
        subset.add(" ");

        for (int i = n - 1; i >= 0; i--) {
            int size = subset.size();

            for (int j = 0; j < size; j++) {
                String newLine = arr[i] + " " + subset.get(j);
                subset.add(newLine);
                count++;

                sb.append(newLine + "\n");
            }
        }

        System.out.println(count + "\n" + sb);

    }
}
