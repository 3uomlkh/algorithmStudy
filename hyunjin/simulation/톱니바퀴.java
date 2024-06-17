package hyunjin.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴 {
    public static StringTokenizer st;
    public static int[][] wheel = new int[4][8];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = s.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int wheelNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            judgeWheel(wheelNum, dir);
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += Math.pow(2, i) * wheel[i][0];
        }
        System.out.println(result);
    }

    public static void judgeWheel (int num, int dir) {
        leftJudge(num - 1, -dir);
        rightJudge(num + 1, -dir);
        rollWheel(num, dir);
    }

    public static void leftJudge(int num, int dir) {
        if (num < 0) return;
        if (wheel[num][2] == wheel[num + 1][6]) return;
        leftJudge(num - 1, -dir);
        rollWheel(num, dir);
    }

    public static void rightJudge(int num, int dir) {
        if (num > 3) return;
        if (wheel[num][6] == wheel[num - 1][2]) return;
        rightJudge(num + 1, -dir);
        rollWheel(num, dir);
    }

    public static void rollWheel(int num, int dir) {
        if (dir == 1) {
            int tempR = wheel[num][7];
            for (int i = 7; i > 0; i--) {
                wheel[num][i] = wheel[num][i - 1];
            }
            wheel[num][0] = tempR;
        } else {
            int tempL = wheel[num][0];
            for (int i = 0; i < 7; i++) {
                wheel[num][i] = wheel[num][i + 1];
            }
            wheel[num][7] = tempL;
        }
    }
}
