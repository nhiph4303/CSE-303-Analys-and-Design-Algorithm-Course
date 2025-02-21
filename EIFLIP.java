import java.io.*;
import java.util.*;

public class EIFLIP {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        int t = sc.nextInt();

        while (t-- > 0) {
            int startState = 0;
            for (int i = 0; i < 3; i++) {
                String row = sc.next();
                for (int j = 0; j < 3; j++) {
                    if (row.charAt(j) == '*') {
                        startState |= (1 << (i * 3 + j));
                    }
                }
            }

            int minSteps = 9;
            for (int mask = 0; mask < (1 << 9); mask++) {
                int flippedState = startState;
                int steps = 0;

                for (int pos = 0; pos < 9; pos++) {
                    if ((mask & (1 << pos)) > 0) {
                        flippedState ^= (1 << pos);
                        int x = pos / 3, y = pos % 3;

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d], ny = y + dy[d];
                            if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                                flippedState ^= (1 << (nx * 3 + ny));
                            }
                        }
                        steps++;
                    }
                }

                if (flippedState == 0) {
                    minSteps = Math.min(minSteps, steps);
                }
            }

            sb.append(minSteps).append("\n");
        }
        System.out.print(sb);
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