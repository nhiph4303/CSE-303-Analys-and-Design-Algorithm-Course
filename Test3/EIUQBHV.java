package Test3;

import java.util.*;

public class EIUQBHV {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String n = sc.next();
        TreeSet<String> tree1 = new TreeSet<>();
        tree1.add("");

        for (int i = 0; i < n.length(); i++) {
            TreeSet<String> tree2 = new TreeSet<>();

            for (String t : tree1) {
                for (int j = 0; j <= t.length(); j++) {
                    tree2.add(t.substring(0, j) + n.charAt(i) + t.substring(j));
                }
            }
            tree1 = tree2;
        }

        for (String t : tree1) {
            sb.append(t + "\n");
        }

        System.out.println(tree1.size() + "\n" + sb);
    }

}
