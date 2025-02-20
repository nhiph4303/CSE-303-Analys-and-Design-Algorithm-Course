package Test1;

import java.util.*;

public class EIPAGES {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // 6
        // 141 142 143 174 175 180

        int n = sc.nextInt();
        List<Integer> pages = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pages.add(sc.nextInt());
        }
        Collections.sort(pages);

        int i = 0;

        while (i < n) {
            int start = pages.get(i);
            int end = start;

            while (i + 1 < n && pages.get(i) + 1 == pages.get(i + 1)) {
                end = pages.get(i + 1);
                i++;
            }

            if (end - start >= 2) {
                sb.append(start).append("-").append(end).append(" ");
            } else if (end - start == 1) {
                sb.append(start).append(" ").append(end).append(" ");
            } else {
                sb.append(start).append(" ");
            }

            i++;
        }

        System.out.println(sb.toString().trim());
    }
}
