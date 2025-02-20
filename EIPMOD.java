import java.io.*;
import java.util.*;

public class EIPMOD {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        long basedNumber = sc.nextInt();
        long powNumber = sc.nextInt();
        long modNumber = sc.nextInt();
        System.out.println(power(basedNumber, powNumber, modNumber));
    }

    static long power(long basedNumber, long powNumber, long modNumber) {
        long result = 1;
        basedNumber = basedNumber % modNumber;

        while (powNumber > 0) {

            if ((powNumber & 1) != 0) {
                result = (result * basedNumber) % modNumber;
            }

            powNumber = powNumber >> 1;
            basedNumber = (basedNumber *= basedNumber) % modNumber;
        }
        return result;
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
