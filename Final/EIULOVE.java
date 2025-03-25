package Final;

import java.util.*;

public class EIULOVE {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long k = sc.nextLong();
        int best = -1;

        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            if (price <= k && price > best) {
                best = price;
            }
        }

        System.out.println(best);
    }
}
