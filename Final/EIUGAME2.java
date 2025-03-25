package Final;

import java.util.*;

public class EIUGAME2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int MOD = 10000000;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] a = new long[n][m];
        long[][] countS = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                countS[i][j] = 1;
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
                long up = a[i][j] + a[i - 1][j];
                long left = a[i][j] + a[i][j - 1];

                if (up > left) {
                    a[i][j] = up;
                    countS[i][j] = countS[i - 1][j] % MOD;
                } else if (up < left) {
                    a[i][j] = left;
                    countS[i][j] = countS[i][j - 1] % MOD;
                } else {
                    a[i][j] = up;
                    countS[i][j] = (countS[i - 1][j] + countS[i][j - 1]) % MOD;
                }
            }
        }

        System.out.println(a[n - 1][m - 1] + " " + countS[n - 1][m - 1]);

    }
}
