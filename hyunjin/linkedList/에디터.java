package hyunjin.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        Stack<String> stk = new Stack<>();

        int cursor = text.length();
        int num = Integer.parseInt(reader.readLine());

        for (int i = 0; i < text.length(); i++) {
            stk.push(String.valueOf(text.charAt(i)));
        }

        for (int j = 0; j < num; j++) {
            String[] input = reader.readLine().split(" ");
            int len = input.length;

            switch (input[0]) {
                case "L" :
                    if (cursor != 0) cursor--;
                    break;
                case "D" :
                    if (cursor <= len) cursor++;
                    break;
                case "B" :
                    if (cursor != 0) stk.remove(--cursor);
                    break;
                case "P" :
                    stk.add(cursor, input[1]);
                    cursor++;
                    break;
            }
        }

        for (int k = 0; k < stk.size(); k++) {
            System.out.print(stk.elementAt(k));
        }
    }
}
