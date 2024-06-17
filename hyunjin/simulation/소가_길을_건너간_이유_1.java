package hyunjin.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소가_길을_건너간_이유_1 {
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] cowInfo = new int[11][1];

        int sum = 0;

        for(int i = 1; i <= 10; i++) {
            cowInfo[i][0] = 2;
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if(cowInfo[num][0] == 2) {
                cowInfo[num][0] = position;
            }
            else {
                if(cowInfo[num][0] != position) {
                    sum++;
                    cowInfo[num][0] = position;
                }
            }
        }

        System.out.println(sum);

    }
}
