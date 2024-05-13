package chaewon.greedy;

import java.io.*;
import java.util.*;

public class 잃어버린_괄호_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split("-");
        int num;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            num = 0;
            StringTokenizer st = new StringTokenizer(arr[i], "+");
            while (st.hasMoreTokens()) {
                num += Integer.parseInt(st.nextToken());
            }

            list.add(num);
        }

        int answer = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            answer -= list.get(i);
        }

        System.out.println(answer);
    }
}
