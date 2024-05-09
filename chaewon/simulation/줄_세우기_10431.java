package chaewon.simulation;

import java.io.*;
import java.util.StringTokenizer;

public class 줄_세우기_10431 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        int[] arr = new int[20]; // 학생들의 키를 담는 배열
        int testNumber = 0; // 테스트 케이스 번호
        while (P-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            testNumber = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(testNumber + " " + getWalkCount(arr));
        }
    }

    public static int getWalkCount(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) count++;
            }
        }

        return count;
    }
}
