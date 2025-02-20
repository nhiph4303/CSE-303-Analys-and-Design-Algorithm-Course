package Test1;

import java.util.*;

public class EIQUEENS {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Set<Integer> usedColumns = new HashSet<>();
        int[] queenColumns = new int[8];

        for (int row = 0; row < 8; row++) {
            String input = sc.next();
            int col = input.lastIndexOf("*");

            if (col == -1 || col != input.lastIndexOf("*") || usedColumns.contains(col)) {
                System.out.println("invalid");
                return;
            }

            usedColumns.add(col);
            queenColumns[row] = col;
        }

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

}
