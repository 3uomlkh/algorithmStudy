package chaewon.Implementation;

import java.io.*;
import java.util.*;

public class 소가_길을_건너간_이유_1_14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());

            if (map.containsKey(number)) {
                if (map.get(number) != move) {
                    result++;
                }
                map.put(number, move);
            } else {
                map.put(number, move);
            }
        }
        System.out.println(result);
    }
}
