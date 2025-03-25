package Final;

import java.util.*;

public class EI2122Q1ADAM1 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int key = num - x;

            if (map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(count);
    }
}
