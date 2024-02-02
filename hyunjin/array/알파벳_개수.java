package hyunjin.array;

import java.util.Arrays;

public class 알파벳_개수 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(func("baekjoon")));
    }

    public static int[] func(String str) {
        int[] answer = new int[26];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
                answer[str.charAt(i) - 97]++;
            }
        }

        return answer;
    }

}
