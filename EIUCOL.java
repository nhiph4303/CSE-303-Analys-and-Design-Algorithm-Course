import java.io.*;
import java.util.*;

public class EIUCOL {
    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);
    static int[][] attack;
    static int[][] beingAttacked;
    static int n;

    public static void main(String[] args) {
        int money = sc.nextInt();
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[money + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int num : arr) {
            for (int i = num; i <= money; i++) {
                if (dp[i - num] != Integer.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], dp[i - num] + 1);
                }
            }
        }
        System.out.println(dp[money]);
    }

    static class Pair {
        int x;
        int y;
        int type;

        public Pair(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static class Horse {
        int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
        int horseX;
        int horseY;

        public Horse(int horseX, int horseY) {
            this.horseX = horseX;
            this.horseY = horseY;
        }

        public void runHorse(int x, int y) {
            for (int i = 0; i < dx.length; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= n) {
                    attack[nextX][nextY]++;
                    runHorse(nextX, nextY);
                }
            }
        }

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