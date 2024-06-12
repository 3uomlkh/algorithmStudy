package hyunjin.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬_만들기 {
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        int[] EngNum = new int[26];

        for (int i = 0; i < name.length(); i++) {
            int index = name.charAt(i) - 65;
            EngNum[index]++;
        }

        int oddNum = 0;
        int oddIndex = 0;

        for (int i = 0 ; i < 26; i++) {
            if (EngNum[i] % 2 != 0) {
                oddNum++;
                oddIndex = i;
            }
        }
        if (oddNum > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            palindrome(EngNum, oddNum, oddIndex);
        }
    }

    public static void palindrome(int[] EngNum, int OddNum, int OddIndex) {

        String palindrome = "";
        sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < EngNum[i] / 2; j++) {
                sb.append((char)(i + 65));
            }
        }

        palindrome += sb.toString();
        String halfPalindrome = sb.reverse().toString();

        sb = new StringBuilder();
        if (OddNum == 1) {
            sb.append((char)(OddIndex + 65));
        }

        palindrome += sb.toString() + halfPalindrome;

        System.out.println(palindrome);
    }
}
