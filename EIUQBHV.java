import java.io.*;
import java.util.*;

public class EIUQBHV {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String n = sc.next();
        TreeSet<String> tree1 = new TreeSet<>();
        tree1.add("");

        for (int i = 0; i < n.length(); i++) {
            TreeSet<String> tree2 = new TreeSet<>();

            for (String s : tree1) {
                for (int j = 0; j <= s.length(); j++) {
                    tree2.add(s.substring(0, j) + n.charAt(i) + s.substring(j));
                }
                tree1 = tree2;
            }
        }

        for (String s : tree1) {
            sb.append(s + "\n");
        }
        System.out.println(tree1.size() + "\n" + sb);
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
