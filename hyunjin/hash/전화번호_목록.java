package hyunjin.hash;

import java.util.HashMap;
import java.util.Map;

public class 전화번호_목록 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();

        // phone_book의 길이만큼 반복하며 map에 phone_book의 각 원소와 인덱스를 저장한다.
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        // phone_book의 길이만큼 반복하며
        for (int i = 0; i < phone_book.length; i++) {
            // 각 phone_book의 원소의 길이만큼 반복
            for (int j = 0; j < phone_book[i].length(); j++) {
                // map에 저장된 key의 값들 중 phone_book이 원소를 0부터j까지 자른 값이 존재하는지 확인
                if (map.containsKey(phone_book[i].substring(0,j))) {
                    // 존재하면 false
                    answer = false;
                }
            }
        }

        return answer;
    }
}
