package chaewon.simulation;

import java.io.*;
import java.util.StringTokenizer;

public class 스택_10828 {
    static int[] stack = new int[10001];
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch(s) {
                case "push" -> push(Integer.parseInt(st.nextToken()));
                case "pop" -> sb.append(pop()).append("\n");
                case "size" -> sb.append(size()).append("\n");
                case "empty" -> sb.append(empty()).append("\n");
                case "top" -> sb.append(top()).append("\n");
            }
        }
    }

    public static void push(int num) {
        stack[size++] = num;
    }

    public static int pop() {
        if (size == 0) return -1;
        else {
            int p = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return p;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) return -1;
        else return 0;
    }

    public static int top() {
        if (size == 0) return -1;
        else {
            return stack[size - 1];
        }
    }
}
