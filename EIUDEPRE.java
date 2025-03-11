import java.io.*;
import java.util.*;

public class EIUDEPRE {
    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        long n = sc.nextLong();
        double c = sc.nextDouble();
        double r = sc.nextDouble();
        System.out.printf("%.7f%n", findX(n, c, r));
    }

    private static double findX(long n, double c, double r) {
        double start = 0;
        double end = 1;
        double temp = c;
        while (end - start >= 0.0000001) {
            double mid = (end + start) / 2;
            for (int i = 0; i < n; i++) {
                temp = temp * (1 - (mid - mid * i / n));
            }
            if (temp > r) {
                start = mid;
            } else {
                end = mid;
            }
            temp = c;
        }

        return start;
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
