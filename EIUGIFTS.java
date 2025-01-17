import java.io.*;
import java.util.*;

public class EIUGIFTS {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int numberOfGifts = sc.nextInt();
        long money = sc.nextLong();

        int[] prices = new int[numberOfGifts];
        for (int i = 0; i < numberOfGifts; i++) {
            prices[i] = sc.nextInt();
        }

        Arrays.sort(prices);

        long maxTotal = -1;
        int minDiff = Integer.MAX_VALUE;

        int left = 0;
        int right = prices.length - 1;

        while (left < right) {
            long total = prices[left] + prices[right];
            int diff = prices[right] - prices[left];

            if (total <= money) {
                if (total > maxTotal || (total == maxTotal && diff < minDiff)) {
                    maxTotal = total;
                    minDiff = diff;
                }
                left++;
            } else {
                right--;
            }
        }

        if (maxTotal == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(maxTotal + " " + minDiff);
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
