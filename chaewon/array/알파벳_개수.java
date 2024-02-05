package chaewon.array;

import java.util.Scanner;

public class 알파벳_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 97]++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
