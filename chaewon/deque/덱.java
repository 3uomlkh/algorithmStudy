package chaewon.deque;

import java.io.*;
import java.util.*;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String order = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(order);
            int x;
            switch(tokenizer.nextToken()) {
                case "push_back" :
                    x = Integer.parseInt(tokenizer.nextToken());
                    deque.addLast(x);
                    break;
                case "push_front" :
                    x = Integer.parseInt(tokenizer.nextToken());
                    deque.addFirst(x);
                    break;
                case "pop_front" :
                    if (!deque.isEmpty()) {
                        sb.append(deque.removeFirst());
                    } else {
                        sb.append("-1");
                    }
                    break;
                case "pop_back" :
                    if (!deque.isEmpty()) {
                        sb.append(deque.removeLast());
                    } else {
                        sb.append("-1");
                    }
                    break;
                case "size" :
                    sb.append(deque.size());
                    break;
                case "empty" :
                    if (deque.isEmpty()) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    break;
                case "front" :
                    if (!deque.isEmpty()) {
                        sb.append(deque.getFirst());
                    } else {
                        sb.append("-1");
                    }
                    break;
                case "back" :
                    if (!deque.isEmpty()) {
                        sb.append(deque.getLast());
                    } else {
                        sb.append("-1");
                    }
                    break;
            }
            if (!sb.toString().isEmpty()) {
                System.out.println(sb);
                sb.setLength(0);
            }
        }
    }
}
