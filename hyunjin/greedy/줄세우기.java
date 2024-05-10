package hyunjin.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int P = Integer.parseInt(br.readLine());

        for (int p = 0; p < P; p++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String T = st.nextToken();
            int[] arr = new int[20];
            int count = 0;

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) {
                        count++;
                    }
                }
            }

            System.out.println(T + " " + count);
        }
    }
}
