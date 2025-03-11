import java.io.*;
import java.util.*;

public class EIULOGGING3 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        long[] k = new long[n];
        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
        }
        long[] dp = new long[n];
        long[] ways = new long[n];
        ways[0] = 1;

        if (n == 1) {
            System.out.println(Math.max(0, k[0]) + " 1");
        } else {
            ways[1] = 1;
            dp[0] = Math.max(0, k[0]);
            if (dp[0] == k[1]) {
                ways[1] = 2;
            }
            dp[1] = Math.max(dp[0], k[1]);

            for (int i = 2; i < dp.length; i++) {
                long dp1 = dp[i - 2] + k[i];
                long dp2 = dp[i - 1];
                if (dp1 == dp2) {
                    ways[i] = (ways[i - 2] + ways[i - 1]) % 1_000_000_007;
                    dp[i] = dp1;
                } else if (dp1 > dp2) {
                    ways[i] = ways[i - 2];
                    dp[i] = dp1;
                } else {
                    ways[i] = ways[i - 1];
                    dp[i] = dp2;
                }

            }
            System.out.println(dp[n - 1] + " " + ways[n - 1] % 1_000_000_007);
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
