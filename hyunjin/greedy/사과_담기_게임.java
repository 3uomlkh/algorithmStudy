package hyunjin.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과_담기_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int num = Integer.parseInt(br.readLine());

        int left = 1;
        int right = left + M - 1;
        int distance = 0;

        for (int i = 0; i < num; i++) {
            int apple = Integer.parseInt(br.readLine());
            if (apple < left) {
                int count = left - apple;
                distance += count;
                left -= count;
                right -= count;
            } else if (apple > right) {
                int count = apple - right;
                distance += count;
                left += count;
                right += count;
            }
        }
        System.out.println(distance);
    }
}
