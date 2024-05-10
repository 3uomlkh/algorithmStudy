package chaewon.hash;

import java.util.HashMap;

public class 전화번호_목록 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[] {"123","456","789"}));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        // phone_book 크기 만큼의 map 생성
        HashMap<String, Integer> map = new HashMap<>(phone_book.length);

        // map에 전화번호 저장
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        // 이중 for문을 돌며 map에 각 배열의 요소를 하나씩 자른 값이 포함되어 있는지 확인(접두사인지)
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                String number = phone_book[i].substring(0, j+1);
                // map.get(number) != i 으로 자기 자신은 제외
                if (map.containsKey(number) && map.get(number) != i) answer = false;
            }
        }

        return answer;
    }
}
