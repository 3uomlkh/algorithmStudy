package chaewon.utilizationOfStack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// 시간 내에 풀리지 않아 검색한 후 푼 문제 - 입출력, Stack 사용법 숙지하기
public class 균형잡힌_세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while(true) {
            input = br.readLine();

            if (input.equals(".")) break;

            sb.append(solve(input)).append('\n'); // StringBuilder로 한 번에 출력해도 통과됨
        }

        System.out.println(sb);
    }

    public static String solve(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            switch (c) {
                case '[' :
                case '(' :
                    stack.addFirst(c);
                    break;
                case ')' :
                    if (stack.isEmpty() || stack.peekFirst() != '(') {
                        return  "no";
                    } else {
                        stack.removeFirst();
                    }
                    break;
                case ']' :
                    if (stack.isEmpty() || stack.peekFirst() != '[') {
                        return  "no";
                    } else {
                        stack.removeFirst();
                    }
                    break;
            }
        }

        if (stack.isEmpty()) return "yes";
        else return "no";
    }
}
