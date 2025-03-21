package Test3;

import java.util.Arrays;
import java.util.Scanner;

public class EIUGAME {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] arr = new long[m + 1];
        Arrays.fill(arr, Long.MIN_VALUE / 2);

        arr[0] = 0;
        arr[1] = 0;
        long temp;

        for (int i = 1; i <= n; i++) {
            arr[1] += sc.nextLong();

            for (int j = 2; j <= m; j++) {
                temp = sc.nextLong();
                arr[j] = Math.max(arr[j], arr[j - 1]) + temp;
            }
        }
        System.out.println(arr[m]);
    }
}
