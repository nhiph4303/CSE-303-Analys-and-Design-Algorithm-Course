import java.io.*;
import java.util.*;
 
public class EISUBSET2 {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] subset = new int[n];

        for (int i = 0; i < subset.length; i++) {
            subset[i] = sc.nextInt();
        }

        List<Integer> subsetList = new ArrayList<>();
        subsetList.add(0);
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            int sizeList = subsetList.size();
            for (int j = 0; j < sizeList; j++) {
                int temp = subsetList.get(j) + subset[i];
                if (temp == k) {
                    count++;
                }
                subsetList.add(temp);
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
