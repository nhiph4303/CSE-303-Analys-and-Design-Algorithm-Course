package Final;

import java.util.*;

public class EIPAGES {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        List<Integer> pages = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pages.add(sc.nextInt());
        }

        int i = 0;
        while (i < n) {
            int start = pages.get(i);
            int end = start;

            if (i + 1 <= n && pages.get(i) + 1 == pages.get(i + 1)) {
                
            }
        }
    }
}
