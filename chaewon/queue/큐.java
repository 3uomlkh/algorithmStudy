package chaewon.queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/*
   StringTokenizer를 시용하는 풀이도 많이 있어서 StringTokenizer에 대해 찾아보았다.
   구분자가 복잡하지 않은 한 문자이고, 반환 타입이 문자열인 경우 StringTokenizer를 사용하는 것이 적합했다.
   (+ StringTokenizer를를 사용할 때 BufferedWriter가 아닌 StringBuilder로 푸는 답안이 많았다.)
*/
public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String order = br.readLine();
            if (order.contains("push")){
                q.addLast(Integer.parseInt(order.substring(5)));
            } else if (order.contains("pop")) {
                if (q.isEmpty()){
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(q.pollFirst()));
                }
                bw.newLine();
                bw.flush();
            } else if (order.equals("size")) {
                bw.write(String.valueOf(q.size()));
                bw.newLine();
                bw.flush();
            } else if (order.equals("empty")) {
                if (q.isEmpty()){
                    bw.write("-1");
                } else {
                    bw.write("0");
                }
                bw.newLine();
                bw.flush();
            } else if (order.equals("front")) {
                if (q.isEmpty()){
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(q.peekFirst()));
                }
                bw.newLine();
                bw.flush();
            } else if (order.equals("back")) {
                if (q.isEmpty()){
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(q.peekLast()));
                }
                bw.newLine();
                bw.flush();
            }
        }
        bw.close();
    }
}
