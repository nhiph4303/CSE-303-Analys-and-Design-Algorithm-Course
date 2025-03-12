
import java.io.*;
import java.util.*;

public class EI2122Q1ADAM2 {

    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        int[] males = new int[n];
        for (int i = 0; i < n; i++) {
            males[i] = sc.nextInt();
        }
        Arrays.sort(males);

        int[] females = new int[m];
        for (int i = 0; i < m; i++) {
            females[i] = sc.nextInt();
        }
        Arrays.sort(females);

        int minH = binarySearch(males, females, x);
        System.out.println(minH);
    }

    static int binarySearch(int[] males, int[] females, int x) {
        int minH = Math.max(males[males.length - 1], females[females.length - 1]) - Math.min(males[0], females[0]);
        int left = 0;
        int right = minH;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (countPairs(males, females, mid, x)) {
                minH = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minH;
    }

    static boolean countPairs(int[] males, int[] females, int h, int x) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < males.length && j < females.length) {
            if (Math.abs(males[i] - females[j]) <= h) {
                count++;
                i++;
                j++;
            } else {
                if (males[i] < females[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return count >= x;
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
