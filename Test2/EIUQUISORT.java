package Test2;

import java.util.*;

public class EIUQUISORT {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        double[] plusArr = addArray(arr);
        shuffleArray(plusArr);
        quickSort(plusArr, 0, n - 1);
        print(plusArr);

    }

    static double[] addArray(long[] arr) {
        double[] addArray = new double[arr.length];
        double x = 0.00000001;

        for (int i = 0; i < arr.length; i++) {
            addArray[i] = arr[i] + (i + 1) * x;
        }
        return addArray;
    }

    static void swap(double[] plusArr, int i, int j) {
        double temp = plusArr[i];
        plusArr[i] = plusArr[j];
        plusArr[j] = temp;
    }

    static void shuffleArray(double[] plusArr) {
        Random rand = new Random();
        for (int i = plusArr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(plusArr, i, j);
        }
    }

    static void quickSort(double[] plusArr, int from, int to) {
        if (from < to) {
            int middle = partition(plusArr, from, to);
            quickSort(plusArr, from, middle - 1);
            quickSort(plusArr, middle + 1, to);
        }
    }

    static int partition(double[] plusArr, int from, int to) {
        double pivot = plusArr[from];
        int i = from;
        for (int j = i + 1; j <= to; j++) {
            if (plusArr[j] < pivot) {
                i++;
                swap(plusArr, i, j);
            }
        }
        swap(plusArr, from, i);
        return i;
    }

    static void print(double[] plusArr) {
        for (double num : plusArr) {
            sb.append((long) num + "\n");
        }
        System.out.print(sb);
    }

}
