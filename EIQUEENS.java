import java.io.*;
import java.util.*;

public class EIQUEENS {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Set<Integer> columnIndexs = new HashSet<>();
        ArrayList<Integer> columns = new ArrayList<>();

        for (int row = 0; row < 8; row++) {
            String input = sc.next();
            int columnIndex = input.indexOf("*");

            if (columnIndex != input.lastIndexOf("*") || columnIndex == -1 || columnIndexs.contains(columnIndex)) {
                System.out.println("invalid");
                return;
            }

            columnIndexs.add(columnIndex); 
            columns.add(columnIndex);    
        }

        // compare all possible pairs
        // first queen: (i,column.get(i))
        // second queen: (j,column.get(j))
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (Math.abs(columns.get(i) - columns.get(j)) == Math.abs(i - j)) {
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
