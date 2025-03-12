import java.io.*;
import java.util.*;

public class EIUQBHV {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String n = sc.next();
        TreeSet<String> tree = new TreeSet<>();
        tree.add(" ");

        for (int i = 0; i < n.length(); i++) {
            TreeSet<String> temp = new TreeSet<>();

            for (String s : tree) {
                for (int j = 0; j <= s.length(); j++) {
                    String t = s.substring(0, j) + n.charAt(i) + s.substring(j);
                    temp.add(t);
                }
            }
            tree = temp;
        }

        sb.append(tree.size()).append("\n");
        tree.forEach((key) -> {
            sb.append(key).append("\n");
        });
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
