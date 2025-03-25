package Final;

import java.util.*;

public class EIEQUALS {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int iA = 0;
        int iB = 0;
        int count = 0;

        while (iA < n && iB < n) {
            if (a[iA] == b[iB]) {
                iA++;
                iB++;
            } else {
                count++;
                if (a[iA] > b[iB]) {
                    iB++;
                } else {
                    iA++;
                }
            }
        }

        if (count > 2) {
            System.out.println("NO");
            return;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        System.out.println(sum > k ? "NO" : "YES");
    }
}
