package Final;

import java.util.*;

public class EIUGAME {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] a = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextLong();
            }
        }

        for (int i = 1; i < n; i++) {
            a[i][0] += a[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            a[0][i] += a[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                a[i][j] += Math.max(a[i - 1][j], a[i][j - 1]);
            }
        }

        System.out.println(a[n - 1][m - 1]);

    }
}
