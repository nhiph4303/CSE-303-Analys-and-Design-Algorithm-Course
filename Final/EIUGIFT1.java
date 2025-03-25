package Final;

import java.util.*;

public class EIUGIFT1 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int g = sc.nextInt();
        int p = sc.nextInt();

        int[] gift = new int[g];
        for (int i = 0; i < g; i++) {
            gift[i] = sc.nextInt();
        }
        Arrays.sort(gift);

        int[] paper = new int[p];
        for (int i = 0; i < p; i++) {
            paper[i] = sc.nextInt();
        }
        Arrays.sort(paper);

        // 4 4
        // 2 2 3 4 i
        // 4 4 6 8
        // 6 6 9 12

        // 5 10 15 20 j

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < g && j < g) {
            if (paper[j] >= gift[i] * 2 && paper[j] <= gift[i] * 3) {
                count++;
                i++;
                j++;
            }else if(paper[j] < gift[i] * 2){
                j++;
            }else{
                i++;
            }
        }

        System.out.println(count);
    }
}
