import java.io.*;
import java.util.*;

public class EIUGAME2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] a = new long[n][m];
        long[][] countSteps = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextLong();
                countSteps[i][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            a[i][0] += a[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            a[0][i] += a[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long up = a[i][j] + a[i - 1][j];
                long left = a[i][j] + a[i][j - 1];

                if (up > left) {
                    a[i][j] = up;
                    countSteps[i][j] = countSteps[i - 1][j] % 10000000;
                } else if (up < left) {
                    a[i][j] = left;
                    countSteps[i][j] = countSteps[i][j - 1] % 10000000;
                } else {
                    a[i][j] = up;
                    countSteps[i][j] = (countSteps[i - 1][j] + countSteps[i][j - 1]) % 10000000;
                }
            }
        }
        System.out.println(a[n - 1][m - 1] + " " + countSteps[n - 1][m - 1]);

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
