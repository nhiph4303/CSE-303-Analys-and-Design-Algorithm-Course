import java.io.*;
import java.util.*;

public class EIUGAME {
    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        long arr[] = new long[m + 1];
        Arrays.fill(arr, Long.MIN_VALUE / 2);
        arr[0] = 0;
        arr[1] = 0;
        long temp;
        for (int i = 1; i <= n; ++i) {
            arr[1] += sc.nextLong();
            for (int j = 2; j <= m; j++) {
                temp = sc.nextLong();
                arr[j] = Math.max(arr[j], arr[j - 1]) + temp;
            }
        }
        System.out.println(arr[m]);
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