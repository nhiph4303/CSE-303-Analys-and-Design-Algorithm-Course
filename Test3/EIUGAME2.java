package Test3;

import java.util.Scanner;

public class EIUGAME2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] a = new long[n][m];
        long[][] countStep = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextLong();
                countStep[i][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            a[i][0] += a[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            a[0][i] += a[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; i < m; i++) {
                long up = a[i][j] + a[i - 1][j];
                long left = a[i][j] + a[i][j - 1];

                if (up > left) {
                    a[i][j] = up;
                    countStep[i][j] = countStep[i - 1][j] % 10000000;
                } else if (up < left) {
                    a[i][j] = left;
                    countStep[i][j] = countStep[i][j - 1] % 10000000;
                } else {
                    a[i][j] = up;
                    countStep[i][j] = (countStep[i - 1][j] + countStep[i][j - 1]) % 10000000;
                }
            }
        }

        System.out.println(a[n - 1][m - 1] + " " + countStep[n - 1][m - 1]);
    }
}
