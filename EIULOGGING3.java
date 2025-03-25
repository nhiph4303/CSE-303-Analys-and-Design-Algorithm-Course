import java.io.*;
import java.util.*;

public class EIULOGGING3 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = sc.nextInt();

        long[] k = new long[n];
        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
        }

        long[] dp = new long[n + 1];
        long[] ways = new long[n + 1];

        dp[0] = 0;
        dp[1] = Math.max(k[0], 0);

        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (dp[i - 1] > dp[i - 2] + k[i - 1]) {
                dp[i] = dp[i - 1];
                ways[i] = ways[i - 1];
            } else if (dp[i - 1] < dp[i - 2] + k[i - 1]) {
                dp[i] = dp[i - 2] + k[i - 1];
                ways[i] = ways[i - 2];
            } else {
                dp[i] = dp[i - 1];
                ways[i] = (ways[i - 1] + ways[i - 2]) % MOD;
            }
        }

        System.out.println(dp[n] + " " + ways[n]);
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
