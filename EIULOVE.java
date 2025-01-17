import java.io.*;
import java.util.*;

public class EIULOVE {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int gifts = sc.nextInt(); 
        int money = sc.nextInt(); 

        int[] prices = new int[gifts];
        for (int i = 0; i < gifts; i++) {
            prices[i] = sc.nextInt(); 
        }
        Arrays.sort(prices); 

        int indexOfPosibleGift = Arrays.binarySearch(prices, money);

        if (indexOfPosibleGift < 0) {
            indexOfPosibleGift = -(indexOfPosibleGift + 1) - 1;
        }

     
        if (indexOfPosibleGift < 0) {
            System.out.println("-1"); 
        } else {
            System.out.println(prices[indexOfPosibleGift]);
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
