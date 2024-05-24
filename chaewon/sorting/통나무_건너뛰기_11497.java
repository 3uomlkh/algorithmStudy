package chaewon.sorting;

import java.io.*;
import java.util.*;

public class 통나무_건너뛰기_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int result = 0;
        while (t-- > 0) {
            int M = Integer.parseInt(br.readLine());
            int[] arr = new int[M];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int[] arr2 = new int[M];
            int left = 0;
            int right = M - 1;

            for (int j = 0; j < M ; j++) {
                if(j%2 == 0){
                    arr2[left] = arr[j];
                    left++;
                }else{
                    arr2[right] = arr[j];
                    right--;
                }
            }

            int diff = Math.abs(arr2[0]-arr2[M-1]);

            for (int j = 1; j < M ; j++) {
                diff = Math.max(diff, Math.abs(arr2[j]  - arr2[j-1]));
            }

            System.out.println(diff);
        }
    }
}
