import java.io.*;
import java.util.*;

public class EIUDP2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static long[] arr;
    static long[] st;
    static long[] sum;
    static long[] dp;

    public static void main(String[] args) {
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sum = new long[n + 1];
            arr = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextLong();
                sum[i] = sum[i - 1] + arr[i];
            }
            dp = new long[n + 1];
            st = new long[4 * n + 1];
            long ans = 0;
            for (int i = 1; i <= n; i++) {
                long maxSum = get(1, 0, n, Math.max(0, i - k), i - 1);
                dp[i] = Math.max((maxSum == Long.MIN_VALUE ? 0 : maxSum) + sum[i], dp[i - 1]);
                ans = Math.max(ans, dp[i]);
                update(1, 0, n, i, dp[Math.max(0, i - k)] - sum[i]);
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }

    static void update(int id, int l, int r, int pos, long val) {
        if (pos < l || pos > r) {
            return;
        }
        if (pos == l && pos == r) {
            st[id] = val;
            return;
        }
        int mid = (l + r) / 2;
        update(id * 2, l, mid, pos, val);
        update(id * 2 + 1, mid + 1, r, pos, val);
        st[id] = Math.max(st[id * 2], st[id * 2 + 1]);
    }

    static long get(int id, int l, int r, int u, int v) {
        if (u > r || v < l) {
            return Long.MIN_VALUE;
        }
        if (u <= l && v >= r) {
            return st[id];
        }
        int mid = (l + r) / 2;
        return Math.max(get(id * 2, l, mid, u, v), get(id * 2 + 1, mid + 1, r, u, v));
    }

    static void buildSum(int id, int l, int r) {
        if (l > r) {
            return;
        }
        if (l == r) {
            st[id] = Long.MIN_VALUE;
            return;
        }
        int mid = (l + r) / 2;
        buildSum(id * 2, l, mid);
        buildSum(id * 2 + 1, mid + 1, r);
        st[id] = Math.max(st[id * 2], st[id * 2 + 1]);
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
