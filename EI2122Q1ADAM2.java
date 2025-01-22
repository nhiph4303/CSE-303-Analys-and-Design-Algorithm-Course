
import java.io.*;
import java.util.*;

public class EI2122Q1ADAM2 {

    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int nMen = sc.nextInt();
        int nWomen = sc.nextInt();
        int nPairs = sc.nextInt();

        double[] menHeights = getHeight(nMen);
        double[] womenHeights = getHeight(nWomen);

        Arrays.sort(menHeights);
        Arrays.sort(womenHeights);

        double minDiff = 0;
        double maxDiff = Math.max(menHeights[nMen - 1], womenHeights[nWomen - 1])
                - Math.min(menHeights[0], womenHeights[0]);

        while (Double.compare(minDiff, maxDiff) <= 0) {
            double middle = (maxDiff + minDiff) / 2;

            if (canFormPairs(menHeights, womenHeights, nPairs, middle)) {
                maxDiff = middle - 1e-9;
            } else {
                minDiff = middle + 1e-9;
            }
        }

        System.out.printf("%.0f%n", minDiff);
    }

    static double[] getHeight(int n) {
        double[] heights = new double[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextDouble();
        }
        return heights;
    }

    static boolean canFormPairs(double[] menHeights, double[] womenHeights, int nPairs, double maxDiff) {
        int i = 0, j = 0, count = 0;

        while (i < menHeights.length && j < womenHeights.length) {
            if (Math.abs(menHeights[i] - womenHeights[j]) <= maxDiff) {
                count++;
                i++;
                j++;
            } else if (menHeights[i] < womenHeights[j]) {
                i++;
            } else {
                j++;
            }

            if (count >= nPairs)
                return true;
        }

        return count >= nPairs;
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
