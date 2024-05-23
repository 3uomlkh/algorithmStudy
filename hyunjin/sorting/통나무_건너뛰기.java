package hyunjin.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 통나무_건너뛰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        System.out.println();

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            int arr[] = new int[M];
            int result[] = new int[M];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M ; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int left = 0;
            int right = M - 1;

            for (int j = 0; j < M ; j++) {
                if(j%2 == 0){
                    result[left] = arr[j];
                    left++;
                }else{
                    result[right] = arr[j];
                    right--;
                }
            }

            int diff = Math.abs(result[0]-result[M-1]);

            for (int j = 1; j < M ; j++) {
                diff = Math.max(diff, Math.abs(result[j]  - result[j-1]));
            }

            System.out.println(diff);
        }
    }
}
