import java.io.*;
import java.util.*;

public class EIQUEENS {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Set<Integer> usedColumns = new HashSet<>();
        int[] queenColumns = new int[8];

        for (int row = 0; row < 8; row++) {
            String input = sc.next();
            int col = input.indexOf("*");

            if (col == -1 || col != input.lastIndexOf("*") || usedColumns.contains(col)) {
                System.out.println("invalid");
                return;
            }

            usedColumns.add(col);
            queenColumns[row] = col;
        }

        // Kiểm tra đường chéo
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (Math.abs(queenColumns[i] - queenColumns[j]) == Math.abs(i - j)) {
                    System.out.println("invalid");
                    return;
                }
            }
        }

        System.out.println("valid");
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
