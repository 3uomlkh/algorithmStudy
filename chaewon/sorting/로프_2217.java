package chaewon.sorting;

import java.io.*;
import java.util.*;

public class 로프_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        for (int i = 0; i < n; i++) {
            ropes[i] *= (n - i);
            max = Math.max(max, ropes[i]);
        }

        System.out.println(max);
    }
}
