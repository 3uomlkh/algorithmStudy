package chaewon.simulation;

import java.io.*;
import java.util.*;

public class 스위치_켜고_끄기_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int i = 1; i <= n; i++) {
                    if (i % num == 0) {
                        if (switches[i] == 1) switches[i] = 0;
                        else switches[i] = 1;
                    }
                }
            } else {
                int start = num - 1;
                int end = num + 1;
                while (start >= 1 && end <= n) {
                    if (switches[start] != switches[end]) break;
                    start--;
                    end++;
                }
                start++;
                end--;
                for (int j = start; j <= end; j++) {
                    switches[j] = switches[j] == 0 ? 1 : 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
