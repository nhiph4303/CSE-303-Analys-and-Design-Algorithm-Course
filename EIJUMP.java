import java.io.*;
import java.util.*;

public class EIJUMP {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < stones.length; i++) {
            stones[i] = sc.nextInt();
        }

        int[] steps = new int[n + 1];
        steps[0] = -1;
        Map<Integer, Integer> stoneIndex = new HashMap<>();
        
        for (int i = 1; i < steps.length; i++) {
            int theStone = stones[i - 1];
            if (stoneIndex.containsKey(theStone) == false) {
                steps[i] = steps[i - 1] + 1;
                stoneIndex.put(theStone, i);
            } else {
                int prevSteps = steps[stoneIndex.get(theStone)];
                steps[i] = Math.min(steps[i - 1], prevSteps);
                steps[i] += 1;
                stoneIndex.put(theStone, i);
            }
        }
        System.out.println(steps[n]);

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
