import java.io.*;
import java.util.*;

public class EIULOGGING3 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
        }
        long[][] dp = new long[2][n + 1];
        if (n == 1) {
            System.out.println((a[1] <= 0 ? 0 : a[1]) + " " + 1);
        } else {

            dp[0][0] = 0;
            dp[0][1] = Math.max(a[1], dp[0][0]);
            dp[1][1] = 1;
            dp[1][0] = 1;
            for (int i = 2; i <= n; i++) {
                long tempSum = a[i] + dp[0][i - 2];
                if (tempSum > dp[0][i - 1]) {
                    dp[1][i] = dp[1][i - 2];
                    dp[0][i] = tempSum;
                } else if (tempSum == dp[0][i - 1]) {
                    dp[0][i] = tempSum;

                    dp[1][i] = (dp[1][i - 2] + dp[1][i - 1]) % 1000000007;

                } else {
                    dp[1][i] = dp[1][i - 1];
                    dp[0][i] = dp[0][i - 1];
                }

            }
            System.out.println(dp[0][n] + " " + dp[1][n]);

        }
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
