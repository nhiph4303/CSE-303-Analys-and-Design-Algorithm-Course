import java.io.*;
import java.util.*;

public class EIULOGGING2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        long[] k = new long[n];
        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
        }
        System.out.print(maxValue(n, k));
    }

    static long maxValue(int n, long[] k) {
        if (n == 1)
            return Math.max(0, k[0]);
        if (n == 2)
            return Math.max(Math.max(0, k[0]), k[1]);

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = Math.max(k[0], 0);
        dp[2] = Math.max(k[1], dp[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + k[i - 1], dp[i - 1]);
        }

        return dp[n];
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
