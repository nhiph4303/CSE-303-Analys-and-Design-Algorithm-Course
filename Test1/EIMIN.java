package Test1;

import java.util.*;

public class EIMIN {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i<n; i++){
            set.add(sc.nextLong());
        }

        long prev = 0;
        ArrayList<Long> result = new ArrayList<>();

        for (long num : set){
            if (result.size() == k){
                break;
            }
            result.add(num-prev);
            prev = num;
        }

        for (long num: result){
            sb.append(num +"\n");
        }

        System.out.println(sb);


    }
}
