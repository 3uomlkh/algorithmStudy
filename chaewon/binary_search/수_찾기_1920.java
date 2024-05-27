package chaewon.binary_search;

import java.io.*;
import java.util.*;

public class 수_찾기_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(a);

        int mid;
        for (int i = 0; i < m; i++) {
            int st = 0;
            int en = a.length - 1;
            int x = b[i];
            while (st <= en) {
                mid = (st + en) / 2;
                if (a[mid] > x) {
                    en = mid - 1;
                } else if (a[mid] < x) {
                    st = mid + 1;
                } else {
                    System.out.println(1);
                    break;
                }
            }
            if (st > en) {
                System.out.println(0);
            }
        }
    }
}
