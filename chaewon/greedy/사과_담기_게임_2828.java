package chaewon.greedy;

import java.io.*;
import java.util.*;

public class 사과_담기_게임_2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int start = 1; // 바구니 시작
        int end = M; // 바구니 끝
        int result = 0;
        while (J-- > 0) {
            int apple = Integer.parseInt(br.readLine());
            if (start > apple) {
                result += (start - apple);
                end -= (start - apple);
                start = apple;
            } else if (end < apple) {
                result += (apple - end);
                start += (apple - end);
                end = apple;
            }
        }

        System.out.println(result);
    }
}
