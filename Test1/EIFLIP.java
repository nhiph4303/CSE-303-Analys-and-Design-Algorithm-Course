package Test1;

import java.util.*;

public class EIFLIP {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            int startState = 0;
            for (int i = 0; i < 3; i++) {
                String row = sc.nextLine();
                for (int j = 0; j < 3; j++) {
                    if (row.charAt(j) == '*') {
                        startState |= (1 << (i * 3 + j)); 
                    }
                }
            }
          
            int minSteps = 9;
            for (int mask = 0; mask < (1 << 9); mask++) {
                int flippedState = startState; 
                int steps = 0;

                for (int pos = 0; pos < 9; pos++) {
                    if ((mask & (1 << pos)) > 0) { 
                        flippedState ^= (1 << pos); 
                        int x = pos / 3, y = pos % 3;

                     
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d], ny = y + dy[d];
                            if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                                flippedState ^= (1 << (nx * 3 + ny));
                            }
                        }
                        steps++;
                    }
                }

                if (flippedState == 0) {
                    minSteps = Math.min(minSteps, steps);
                }
            }

            sb.append(minSteps).append("\n");
        }
        System.out.print(sb);
    }
}