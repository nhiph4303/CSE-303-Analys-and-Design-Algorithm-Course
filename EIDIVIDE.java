import java.io.*;
import java.util.*;

public class EIDIVIDE {
    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) throws IOException {
        long n = sc.nextLong();
        long left = sc.nextLong();
        long right = sc.nextLong();

        long maxLength = (long) (Math.log(n) / Math.log(2));
        if (Math.pow(2, maxLength) > n) {
            maxLength--;
        }
        long ans = 0;
        while (maxLength >= 0) {
            if (n % 2 == 1) {
                ans += check(maxLength, left, right);
            }
            maxLength--;
            n /= 2;
        }
        System.out.println(ans);
    }

    static long check(long level, long left, long right) {
        long maxLeft = (long) Math.ceil((left - Math.pow(2, level)) / Math.pow(2, level + 1));
        long maxRight = (long) Math.floor((right - Math.pow(2, level)) / Math.pow(2, level + 1));
        if (maxLeft > maxRight) {
            return 0;
        }
        return maxRight - maxLeft + 1;
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
