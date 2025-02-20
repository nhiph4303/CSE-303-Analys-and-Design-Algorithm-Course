package Test1;
// 5

// 20 30 10 50 40
// Output:
// 4

import java.util.*;

public class EIPAINTING {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i<n; i++){
            int pics = sc.nextInt();
            map.put(pics, map.getOrDefault(pics, 0) + 1);
        }

        int maxRepeat = Collections.max(map.values());

        int count = n - maxRepeat;
        System.out.println(count);
    }
}
