import java.io.*;
import java.util.*;

public class EIULOVE {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int gift = sc.nextInt();
        long money = sc.nextLong();

        long[] price = new long[gift];
        for (int i = 0; i < gift; i++) {
            price[i] = sc.nextLong();
        }

        Arrays.sort(price);

        int indexOfGift = Arrays.binarySearch(price, money);

        if (indexOfGift < 0) {
            indexOfGift = -(indexOfGift + 1) - 1;
        }

        if (indexOfGift < 0) {
            System.out.println("-1");
        } else {
            System.out.println(price[indexOfGift]);
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
