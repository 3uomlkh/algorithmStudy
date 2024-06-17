package chaewon.data_structure;

import java.io.*;
import java.util.*;

public class 나는야_포켓몬_마스터_이다솜_1620 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[n + 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < n + 1; i++) {
            String name = br.readLine();
            map.put(name, i);
            arr[i] = name;
        }

        while(m-- > 0) {
            String find = br.readLine();
            if (isStringNumber(find)) {
                int idx = Integer.parseInt(find);
                sb.append(arr[idx]);
            } else {
                sb.append(map.get(find));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isStringNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
