package chaewon.greedy;

import java.util.Scanner;

public class 팰린드롬_만들기_1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int odd = 0;
        int[] alpha = new int[26];

        for (int i = 0; i < name.length(); i++) {
            int idx = name.charAt(i) - 'A';
            alpha[idx]++;
        }

        for (int k : alpha) {
            if (k % 2 != 0) odd++;
        }

        String result = "";
        if (odd > 1) System.out.println("I'm Sorry Hansoo");
        else {
            StringBuilder start = new StringBuilder();
            StringBuilder mid = new StringBuilder();
            for (int i = 0; i < alpha.length; i++) {
                char c = (char) (i + 65);
                start.append(String.valueOf(c).repeat(alpha[i] / 2));
                if (alpha[i] % 2 != 0) {
                    mid.append(c);
                }
            }
            result += start.toString();
            String end = start.reverse().toString();
            result += mid + end;
        }
        System.out.println(result);
    }
}
