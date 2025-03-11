import java.io.*;
import java.util.*;

public class EIJUMP {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args){
        int n = sc.nextInt();
        int[][] a = new int[2][n];
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            a[0][i] = sc.nextInt();
            a[1][i] = Integer.MAX_VALUE;
            Queue<Integer> tempQueue = map.getOrDefault(a[0][i], new ArrayDeque<>());
            tempQueue.add(i);
            map.put(a[0][i], tempQueue);
        }

        a[1][0] = 0;
        int size = n - 1;
        for (int i = 0; i < size; i++) {
            Queue<Integer> tempQueue = map.get(a[0][i]);
            a[1][i + 1] = Math.min(a[1][i + 1], 1 + a[1][i]);
            if (tempQueue.size() >= 2) {
                tempQueue.poll();
                int index = tempQueue.peek();
                a[1][index] = Math.min(a[1][index], 1 + a[1][i]);
            }
        }

        System.out.println(a[1][n - 1]);

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
