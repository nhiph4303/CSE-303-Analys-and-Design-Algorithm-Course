import java.io.*;
import java.util.*;

public class EIPAINTING {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int picture = sc.nextInt();
            map.put(picture, map.getOrDefault(picture, 0) + 1);
        }

        List<Integer> value = new ArrayList<>(map.values());
        value.sort((a1, a2) -> a2 - a1);

        int maxRepeat = value.get(0);
        // int maxRepeat = value.getFirst();

        // 5
        // 20 30 10 50 40
        // 10 20 30 40 50
        // 4

        // 4
        // 200 100 100 200
        // 100 100 200 200
        // 2

        int count = n - maxRepeat;

        // In kết quả
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