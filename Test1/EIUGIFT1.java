package Test1;

import java.util.*;

public class EIUGIFT1 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int g = sc.nextInt();
        int p = sc.nextInt();

        int[] gifts = new int[g];
        for (int i = 0; i < g; i++) {
            gifts[i] = sc.nextInt();
        }
        Arrays.sort(gifts);

        int[] papers = new int[p];
        for (int i = 0; i < p; i++) {
            papers[i] = sc.nextInt();
        }
        Arrays.sort(papers);

        // 4 4
        // 2 2 3 4 i
        // 4 4 6 8
        // 6 6 9 12

        // 5 10 15 20 j
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < g && j < p) {
            if (papers[j] >= gifts[i] * 2 && papers[j] <= gifts[i] * 3) {
                count++;
                i++;
                j++;
            } else if (papers[j] < gifts[i] * 2) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println(count);
    }
}
