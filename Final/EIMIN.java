package Final;

import java.util.*;

public class EIMIN {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        TreeSet<Long> tree = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            tree.add(sc.nextLong());
        }

        long prev = 0L;
        List<Long> list = new ArrayList<>();

        for (long num : tree) {
            if (list.size() == k) {
                break;
            }
            list.add(num - prev);
            prev = num;
        }

        for (int i = 0; i < k; i++) {
            if (list.size() < k) {
                list.add(0L);
            }
        }

        for(long num : list){
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }
}
