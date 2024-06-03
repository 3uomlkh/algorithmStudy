package chaewon.binary_search;

import java.io.*;
import java.util.*;

public class 과자_나눠주기_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] snack = new int[n];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);

        int left = 1;
        int right = snack[n - 1];

        while (left <= right) {
            int count = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < n; i++) {
                count += snack[i] / mid;
            }

            if (count >= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
