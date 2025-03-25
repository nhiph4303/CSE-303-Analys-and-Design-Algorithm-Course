import java.io.*;
import java.util.*;

public class EITHIEF2 {
    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int p = sc.nextInt();

        int[] weight = new int[n];
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }

        long[] dp = new long[p + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = p; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);
            }
        }
        long max = -1;
        for (long num : dp) {
            max = Math.max(max, num);
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
