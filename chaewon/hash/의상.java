package chaewon.hash;

import java.util.HashMap;
import java.util.Iterator;

public class 의상 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        // clothes 크기 만큼의 map 생성
        HashMap<String, Integer> map = new HashMap<>(clothes.length);

        // clothes[i][0] : 의상 이름, clothes[i][1] : 의상 종류
        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1])) { // map에 해당 의상 종류가 있으면 실행
                map.put(cloth[1], map.get(cloth[1]) + 1); // 그 전 value에 +1
                continue;
            }
            map.put(cloth[1], 1); // map에 해당 의상 종류가 없으면 추가
        }
        // 의상 종류와 의상 종류별 개수가 map에 저장됨

        // Iterator를 이용해 map에서 value값 꺼내기(의상 종류별 개수)
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;

        while (it.hasNext()) { // 다음 요소가 없을 때까지 반복
            answer *= it.next() + 1; // 의상을 착용하지 않을 경우의 수 각 +1
        }

        return answer - 1; // 아무 의상도 착용하지 않았을 경우는 빼서 리턴
    }
}
