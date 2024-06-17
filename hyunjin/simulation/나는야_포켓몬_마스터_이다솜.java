package hyunjin.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜 {
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer,String> numFirstMap = new HashMap<>();
        Map<String,Integer> nameFirstMap = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String pocketmon = br.readLine();
            numFirstMap.put(i, pocketmon);
            nameFirstMap.put(pocketmon, i);
        }

        for(int i = 0; i < M; i++) {
            String s = br.readLine();

            if(s.charAt(0) >= 49 && s.charAt(0) <= 57) {
                int key = Integer.parseInt(s);
                System.out.println(numFirstMap.get(key));
            }
            else {
                System.out.println(nameFirstMap.get(s));
            }
        }
    }
}
