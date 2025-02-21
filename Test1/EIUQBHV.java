package Test1;

import java.util.*;

public class EIUQBHV {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int count;
    static char[] arr;

    public static void main(String[] args) {
        arr = sc.next().toCharArray();
        Arrays.sort(arr);
        sb.append(String.valueOf(arr)).append("\n");
        count++;
        while (nextPermutation()) {
            sb.append(String.valueOf(arr)).append("\n");
            count++;
        }
        System.out.println(count + "\n" + sb);
    }

    static boolean nextPermutation() {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        swap(i, j);
        reverse(i + 1, arr.length - 1);
        return true;
    }

    static void reverse(int start, int end) {
        while (start < end) {
            swap(start++, end--);
        }
    }

    static void swap(int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
