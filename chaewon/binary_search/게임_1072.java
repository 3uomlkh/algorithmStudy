package chaewon.binary_search;

import java.util.*;
import java.io.*;

public class 게임_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());

        long x = Long.parseLong(stn.nextToken());
        long y = Long.parseLong(stn.nextToken());
        long z = (y / x) * 100;

        if (z >= 99) {
            System.out.println(-1);
        } else {
            long st = 0;
            long en = 1000000000;

            while (st <= en) {
                long mid = (st + en) / 2;
                long newZ = (y + mid) * 100 / (x + mid);

                if (newZ > z) {
                    en = mid;
                } else {
                    st = mid + 1;
                }
            }
            System.out.println(en);
        }
    }
}
