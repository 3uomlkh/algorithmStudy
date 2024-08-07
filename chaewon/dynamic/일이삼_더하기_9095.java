package chaewon.dynamic;

import java.io.*;

public class 일이삼_더하기_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11];

            dp[1] = 1; // {1}
            dp[2] = 2; // {1+1, 2}
            dp[3] = 4; // {1+1+1, 2+1, 1+2, 3}
            // 4 = {1+3, 2+2, 3+1}

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]; // 점화식
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
