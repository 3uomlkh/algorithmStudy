package hyunjin.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        long max = Long.MAX_VALUE;
        int a = 0;
        int b = 0;

        while (left < right) {
            long result = arr[left] + arr[right];

            if (max > Math.abs(result)) {
                max = Math.abs(result);
                a = left;
                b = right;
            }
            if (result >= 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(arr[a] + " " + arr[b]);

    }
}
