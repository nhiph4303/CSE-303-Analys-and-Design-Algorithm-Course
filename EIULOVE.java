import java.io.*;
import java.util.*;

public class EIULOVE {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        long money = sc.nextLong();

        TreeSet<Long> prices = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            prices.add(sc.nextLong());
        }

        Long bestGift = prices.floor(money);
        System.out.println(bestGift == null ? "-1" : bestGift);

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
