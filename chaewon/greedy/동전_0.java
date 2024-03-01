package chaewon.greedy;

import java.util.*;
import java.io.*;
// 그리디 알고리즘 : 현재 차례의 최선의 답을 찾는 알고리즘
public class 동전_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전 종류의 개수
        int k = Integer.parseInt(st.nextToken()); // 동전의 합
        int[] coins = new int[n];

        // 동전의 종류를 오름차순으로 입력해 배열에 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) { // 배열의 끝에서 시작해 가장 큰 가치의 동전부터 순회
            if (coins[i] <= k) { // 동전의 가치가 동전의 합보다 작거나 같다면
                count += k / coins[i]; // 해당 가치로 k를 나눈 값을 count에 저장
                k = k % coins[i]; // k에 그 나머지를 저장
            }
        }
        System.out.println(count);
    }
}
