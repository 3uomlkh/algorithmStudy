package chaewon.dynamic;

import java.io.*;

public class 일로_만들기 {
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1; // 1을 빼는 경우를 먼저 넣고 시작
            if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1); // 2로 나누어지는 경우, 1을 뺐을 때 횟수와 2로 나눴을 때 횟수 중 더 작은 값 대입
            if (i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1); // 3으로 나누어지는 경우, 1을 뺐을 때 횟수와 3으로 나눴을 때 횟수 중 더 작은 값 대입
        }

        System.out.println(d[n]);
    }
}
