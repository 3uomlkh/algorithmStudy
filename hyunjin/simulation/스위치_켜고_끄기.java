package hyunjin.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치_켜고_끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int switchNum = Integer.parseInt(br.readLine());
        int[] switchStatus = new int[switchNum + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchNum; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 1; i <= studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                switchBoy(switchNum, number, switchStatus);
            } else {
                switchGirl(switchNum, number, switchStatus);
            }
        }

        for (int i = 1; i <= switchNum; i++) {
            System.out.print(switchStatus[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static void switchBoy (int switchNum, int studentSwitch, int[] switchStatus) {
        for (int i = 1; i <= switchNum; i++) {
            if (i % studentSwitch == 0) {
                if (switchStatus[i] == 1) {
                    switchStatus[i] = 0;
                } else {
                    switchStatus[i] = 1;
                }
            }
        }
    }

    public static void switchGirl (int switchNum, int studentSwitch, int[] switchStatus) {
        int start = studentSwitch - 1;
        int end = studentSwitch + 1;
        while (start >= 1 && end <= switchNum) {
            if (switchStatus[start] != switchStatus[end]) break;
            start--;
            end++;
        }
        start++;
        end--;
        for (int j = start; j <= end; j++) {
            switchStatus[j] = switchStatus[j] == 0 ? 1 : 0;
        }
    }
}
