package chaewon.sorting1;

import java.io.*;
import java.util.*;

public class 배열_합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] c = new int[n+m];
        int indexA = 0;
        int indexB = 0;
        for (int i = 0; i < n+m; i++) {
            if (indexA == n) c[i] = b[indexB++];
            else if (indexB == m) c[i] = a[indexA++];
            else if (a[indexA] >= b[indexB]) c[i] = b[indexB++];
            else c[i] = a[indexA++];
        }

        for (int i = 0; i < n+m; i++) {
            bw.write(c[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
