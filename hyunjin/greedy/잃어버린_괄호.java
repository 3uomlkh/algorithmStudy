package hyunjin.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 잃어버린_괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        String str = br.readLine();
        String[] strArr = str.split("-");

        for (int i = 0; i < strArr.length; i++) {
            int sum = 0;
            String[] strArr2 = strArr[i].split("\\+");
            for (int j = 0; j < strArr2.length; j++) {
                sum += Integer.parseInt(strArr2[j]);
            }
            list.add(sum);
        }

        long answer = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            answer -= list.get(i);
        }

        System.out.println(answer);
        br.close();
    }
}
