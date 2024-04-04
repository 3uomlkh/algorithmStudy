package chaewon.stack_queue;

import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) {
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
    }

    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty() || c == '(') { // 스택이 비어있거나 c가 여는 괄호일때만 스택에 저장
                stack.push(c);
            } else if (c == ')') {
                if (stack.pop() != '(') return false; // c가 닫는 괄호일 때 스택의 제일 위쪽이 닫는 괄호가 아니라면 false
            }
        }

        // 반복문이 모두 끝났는데 스택이 비어있지 않다면 false
        if (!stack.isEmpty()) return false;

        return answer;
    }
}
