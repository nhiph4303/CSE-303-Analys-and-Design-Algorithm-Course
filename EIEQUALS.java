import java.io.*;
import java.util.*;

public class EIEQUALS {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int indexA = 0;
        int indexB = 0;
        int count = 0;
        while (indexA < n && indexB < n) {
            if (a[indexA] == b[indexB]) {
                indexA++;
                indexB++;
            } else {
                count++;
                if (a[indexA] > b[indexB]) {
                    indexB++;
                } else {
                    indexA++;
                }
            }
        }
        if (count > 2) {
            System.out.println("NO");
            return;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        System.out.println(sum > k ? "NO" : "YES");
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