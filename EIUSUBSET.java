import java.io.*;
import java.util.*;

public class EIUSUBSET {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        String[] subset = new String[n];

        for (int i = 0; i < n; i++) {
            subset[i] = sc.next();
        }

        List<String> subSetList = new ArrayList<>();
        subSetList.add(" ");
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currentSize = subSetList.size();

            for (int j = 0; j < currentSize; j++) {
                String newSubset = subset[i] + " " + subSetList.get(j);

                subSetList.add(newSubset);
                count++;
                sb.append(newSubset.trim()).append("\n");
            }
        }

        System.out.println(count + "\n" + sb.toString());
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
