package hyunjin.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수_찾기 {
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] arrN = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] arrM = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N - 1;
            int x = arrM[i];

            while (left <= right) {
                int mid = (left + right) / 2;
                if (arrN[mid] > x) {
                    right = mid - 1;
                } else if (arrN[mid] < x) {
                    left = mid + 1;
                } else {
                    System.out.println(1);
                    break;
                }
            }
            if (left > right) {
                System.out.println(0);
            }
        }
    }
}
