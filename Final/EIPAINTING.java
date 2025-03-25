package Final;

import java.util.*;

public class EIPAINTING {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        TreeMap<Long, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            long pic = sc.nextLong();
            map.put(pic, map.getOrDefault(pic, 0) + 1);
        }

        int maxRepeat = Collections.max(map.values());
        System.out.println(n - maxRepeat);
    }
}
