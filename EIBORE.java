import java.io.*;
import java.util.*;

public class EIBORE {
    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] arr = new long[100001];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[num] += num;
        }
        long max = 0;
        for (int i = 2; i <= 100000; i++) {
            if (i >= 3) {
                arr[i] = Math.max(arr[i] + arr[i - 3], arr[i] + arr[i - 2]);
            } else {
                arr[i] += arr[i - 2];
            }
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
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
