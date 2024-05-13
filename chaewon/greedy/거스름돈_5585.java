package chaewon.greedy;

import java.io.*;

public class 거스름돈_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int change = 1000 - price; // 타로가 지불할 돈
        int count = 0; // 잔돈의 개수
        int[] changes = {500, 100, 50, 10, 5, 1};

        for (int j : changes) {
            count += change / j;
            change = change % j;
        }

        System.out.println(count);
    }
}
