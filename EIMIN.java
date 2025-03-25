import java.io.*;
import java.util.*;

public class EIMIN {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        TreeSet<Long> tree = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            tree.add(sc.nextLong());
        }

        Long prev = 0L;
        List<Long> result = new ArrayList<>();

        for (long num : tree) {
            if (result.size() == k) {
                break;
            }

            result.add(num - prev);
            prev = num;
        }
        
        for (int i = 0; i < k; i++) {
            if (result.size() < k) {
                result.add(0L);
            }
        }
        

        for (long res : result) {
            sb.append(res + "\n");
        }

        System.out.println(sb);
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