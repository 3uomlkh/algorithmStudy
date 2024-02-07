package chaewon.stack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<String> stack = new ArrayDeque<>(); // Stack 클래스보다 Deque 인터페이스 사용 권장

        while (n-- > 0) {
            String order = br.readLine();

            if (order.contains("push")) {
                stack.push(order.substring(5));
            } else if (order.equals("pop")) {
                if (!stack.isEmpty()) {
                    bw.write(stack.pop());
                } else {
                    bw.write("-1");
                }
                bw.newLine();
                bw.flush();
            } else if (order.equals("size")) {
                bw.write(String.valueOf(stack.size()));
                bw.newLine();
                bw.flush();
            } else if (order.equals("empty")) {
                if (stack.isEmpty()) {
                    bw.write("1");
                }
                else {
                    bw.write("0");
                }
                bw.newLine();
                bw.flush();
            } else if (order.equals("top")) {
                if (stack.isEmpty()) {
                    bw.write("-1");
                }
                else {
                    bw.write(String.valueOf(stack.peekFirst()));
                }
                bw.newLine();
                bw.flush();
            }
        }

        bw.close();
    }
}
