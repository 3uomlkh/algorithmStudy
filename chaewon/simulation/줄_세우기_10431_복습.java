package chaewon.simulation;

import java.io.*;
import java.util.*;

public class 줄_세우기_10431_복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (p-- > 0) {
            sb.setLength(0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            sb.append(t).append(" ");
            int[] arr = new int[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) count++;
                }
            }

            sb.append(count);
            System.out.println(sb);
        }
    }
}
