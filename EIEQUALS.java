import java.io.*;
import java.util.*;

public class EIEQUALS {
    static InputReader sc = new InputReader(System.in);
    static long unmatchedValue = 0;
    static boolean isValid = true;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        Map<Integer, Integer> mapA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            mapA.put(num, mapA.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            mapB.put(num, mapB.getOrDefault(num, 0) + 1);
        }

        int unmatchedCount = 1;
        Set<Integer> keysB = mapB.keySet();

        for (Map.Entry<Integer, Integer> entryA : mapA.entrySet()) {
            int valueA = entryA.getKey();
            int countA = entryA.getValue();

            if (!mapB.containsKey(valueA)) {
                if (countA > 1 || unmatchedCount < 1) {
                    System.out.println("NO");
                    return;
                }
                unmatchedValue = valueA; 
                unmatchedCount--;
            } else {
                if (mapB.get(valueA).equals(countA)) {
                    keysB.remove(valueA);
                }
            }
        }

        if (keysB.size() > 1) {
            isValid = false;
        } else {
            keysB.forEach((valueB) -> {
                if (Math.abs((long) valueB - unmatchedValue) > k) {
                    isValid = false;
                }
            });
        }

        System.out.println(isValid ? "YES" : "NO");
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