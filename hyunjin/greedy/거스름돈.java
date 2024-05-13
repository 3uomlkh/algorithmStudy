package hyunjin.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int change = 1000 - Integer.parseInt(br.readLine());
        int count = 0;
        int[] money = {500, 100, 50, 10, 5, 1};

//        int i = 0;
//        while (change != 0) {
//            if (change - money[i] >= 0) {
//                change -= money[i];
//                count++;
//            } else {
//                i++;
//            }
//        }

        for(int m : money) {
            count += change / m;
            change %= m;
        }

        System.out.print(count);
    }
}
