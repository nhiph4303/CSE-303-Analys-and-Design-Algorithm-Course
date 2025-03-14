package Test1;

import java.util.*;

public class EIUDEPRE {
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long n = sc.nextLong();
        double c = sc.nextDouble();
        double r = sc.nextDouble();
        System.out.printf("%.7f%n", findX(n, c, r));

    }

    private static double findX(long n, double c, double r) {
        double start = 0;
        double end = 1;
        double temp = c;
        while (end - start >= 0.0000001) {
            double mid = (end + start) / 2;
            for (int i = 0; i < n; i++) {
                temp = temp * (1 - (mid - mid * i / n));
            }
            if (temp > r) {
                start = mid;
            } else {
                end = mid;
            }
            temp = c;
        }

        return start;
    }
}