package chaewon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

/*
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    - 수열은 사전 순으로 증가하는 순서로 출력
    - 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력
 */
public class N과_M_1 {
    static int n, m;
    static int[] arr; // 수열을 담을 배열
    static boolean[] isUsed; // 특정 수가 사용되었는지 나타내는 배열(중복 여부 판단)
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isUsed = new boolean[n + 1];
        arr = new int[m + 1];

        recursion(0);
        System.out.println(sb);
    }
    private static void recursion(int idx) {
        if (idx == m) { // 재귀를 끝낼 조건 : index가 m과 같다면 arr 배열의 모든 원소 출력
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) { // 수가 사용되지 않았다면
                isUsed[i] = true; // 사용되었다고 체크
                arr[idx] = i;
                recursion(idx + 1); // arr의 인덱스를 +1 시켜주기
                isUsed[i] = false; // 재귀 호출이 다 끝나면 다시 false로 바꿔주기
            }
        }
    }
}
