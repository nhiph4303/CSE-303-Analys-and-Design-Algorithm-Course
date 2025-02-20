import java.io.*;
import java.util.*;

public class EIUGIFT1 {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int g = sc.nextInt();
        int p = sc.nextInt();

        int[] gifts = new int[g];
        for (int i = 0; i < g; i++) {
            gifts[i] = sc.nextInt();
        }
        Arrays.sort(gifts);

        int[] papers = new int[p];
        for (int i = 0; i < p; i++) {
            papers[i] = sc.nextInt();
        }
        Arrays.sort(papers);

        // 4 4
        // 2 2 3 4 i
        // 4 4 6 8
        // 6 6 9 12

        // 5 10 15 20 j
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < g && j < p) {
            if (papers[j] >= gifts[i] * 2 && papers[j] <= gifts[i] * 3) {
                count++;
                i++;
                j++;
            } else if (papers[j] < gifts[i] * 2) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println(count);
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