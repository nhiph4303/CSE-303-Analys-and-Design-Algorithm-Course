import java.io.*;
import java.util.*;

public class EIUQBHV {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static int count;
    static char[] arr;

    public static void main(String[] args) throws IOException {
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

    static class InputReader {

        StringTokenizer tokenizer;

        BufferedReader reader;

        String token;

        String temp;

        public InputReader(InputStream stream) {

            tokenizer = null;

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public InputReader(FileInputStream stream) {

            tokenizer = null;

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public String nextLine() throws IOException {

            return reader.readLine();

        }

        public String next() {

            while (tokenizer == null || !tokenizer.hasMoreTokens()) {

                try {

                    if (temp != null) {

                        tokenizer = new StringTokenizer(temp);

                        temp = null;

                    } else {

                        tokenizer = new StringTokenizer(reader.readLine());

                    }

                } catch (IOException e) {

                }

            }

            return tokenizer.nextToken();

        }

        public double nextDouble() {

            return Double.parseDouble(next());

        }

        public int nextInt() {

            return Integer.parseInt(next());

        }

        public long nextLong() {

            return Long.parseLong(next());

        }

    }
}
