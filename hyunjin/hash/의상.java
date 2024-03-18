package hyunjin.hash;

import java.util.HashMap;
import java.util.Iterator;

public class 의상 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>(clothes.length);

        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
                continue;
            }
            map.put(clothes[i][1], 1);
        }

        for (Integer integer : map.values()) {
            answer *= integer + 1;
        }

        return answer - 1;
    }
}
