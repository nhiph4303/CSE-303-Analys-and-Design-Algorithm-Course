package Test1;

import java.util.*;

public class EIULOVE {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long money = sc.nextLong();

        TreeSet<Long> set = new TreeSet<>();
        for (int i =0; i<n; i++){
            set.add(sc.nextLong());
        }

        Long bestGift = set.floor(money);
        System.out.println(bestGift == null ? "-1" : bestGift);
    }
}
