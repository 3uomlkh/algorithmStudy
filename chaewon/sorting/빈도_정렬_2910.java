package chaewon.sorting;

import java.io.*;
import java.util.*;

public class 빈도_정렬_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        List<Integer> original = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        HashMap<Integer, Integer> map = new HashMap<>(); // 각 숫자의 빈도 수를 저장하는 해시맵
        for (int i = 0; i < n; i++) {
            int key = list.get(i);
            original.add(key);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        list.sort((o1, o2) -> {
            if (!Objects.equals(map.get(o1), map.get(o2))) { // 빈도 수가 다를 경우 -> 빈도 수 내림차순 정렬
                return map.get(o2) - map.get(o1);
            } else { // 빈도 수가 같을 경우 -> 먼저 나온 순으로(원래 배열의 순서대로)
                return original.indexOf(o1) - original.indexOf(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
