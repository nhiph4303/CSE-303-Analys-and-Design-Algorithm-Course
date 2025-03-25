package Final;

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

        double[] stablleArr = add(arr);
        makeShuffle(stablleArr);
        quickSort(stablleArr, 0, n - 1);
        print(stablleArr);
    }

    static void quickSort(double[] arr, int from, int to) {
        if (from < to) {
            int middle = partition(arr, from, to);

            quickSort(arr, from, middle - 1);
            quickSort(arr, middle + 1, to);
        }
    }

    static int partition(double[] arr, int from, int to) {
        double pivot = arr[from];
        int i = from;
        for (int j = i + 1; j <= to; j++) {
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, from, i);
        return i;
    }

    static void makeShuffle(double[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    static double[] add(long[] arr) {
        double[] stablleArr = new double[arr.length];
        double x = 0.00000001;
        for (int i = 0; i < arr.length; i++) {
            stablleArr[i] = arr[i] + x * (i + 1);
        }
        return stablleArr;
    }

    static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(double[] arr) {
        for (double a : arr) {
            sb.append((long) a + "\n");
        }
        System.out.println(sb);
    }

}
