import java.io.*;
import java.util.*;

public class EIUDEPRE {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int nYears = sc.nextInt();
        double initialValue = sc.nextInt();
        double residualValue = sc.nextInt();
        double lowerBound = .0;
        double upperBound = 1.0;
        double temp = 0;
        double middle = 0.0;
        while (Double.compare(lowerBound, upperBound) < 1) {
            middle = (upperBound + lowerBound) / 2;
            temp = (calResult(0, nYears, middle) * initialValue);
            if (Double.compare(temp, residualValue) == 0) {
                break;
            } else if (Double.compare(temp, residualValue) > 0) {
                lowerBound = middle + 0.00000001;
            } else {
                upperBound = middle - 0.00000001;
            }
        }
        System.out.println(lowerBound);

    }

    private static double calResult(int count, int nYears, double middle) {
        if (count >= nYears) {
            return 1.0;
        }
        return (1.0 - middle * (1.0 - ((double) count / (double) nYears))) * calResult(count + 1, nYears, middle);
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
