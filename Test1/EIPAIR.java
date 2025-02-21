package Test1;

import java.util.*;

public class EIPAIR {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int price = sc.nextInt();
                map.put(price, map.getOrDefault(price, 0) + 1);
            }

            long way = 0;
            for (int count : map.values()) {
                if (count > 1) {
                    way+= (long) count * (count - 1) / 2;
                }
            }

            sb.append(way + "\n");
        }

        System.out.println(sb);
    }
}
