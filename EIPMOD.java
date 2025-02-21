import java.io.*;
import java.util.*;

public class EIPMOD {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) throws IOException {
        long x = sc.nextLong();
        long n = sc.nextLong();
        long k = sc.nextLong();
        if (n == 0) {
            System.out.println(1 % k);
        } else {
            long ans = 1;
            x = x % k;

            while (n > 0) {
                if (n % 2 == 1) {
                    ans = (ans * x) % k;
                }

                n /= 2;
                x = (x * x) % k;
            }
            System.out.println(ans);
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
