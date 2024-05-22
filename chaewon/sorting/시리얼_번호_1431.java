package chaewon.sorting;

import java.io.*;
import java.util.*;

public class 시리얼_번호_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) { // n개의 시리얼 번호 입력
            list.add(br.readLine());
        }

        // Comparator 사용해 정렬하기
        list.sort((o1, o2) -> {
            // 1. 시리얼 번호의 길이가 다를 경우, 짧은 것이 먼저 온다.(오름차순)
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else { // 2. 길이가 같을 경우, 각 시리얼 번호의 모든 자리수의 합이 작은 것이 먼저 온다.(오름차순)
                // 자리수의 합을 저장할 변수
                int a = 0;
                int b = 0;
                for (int i = 0; i < o1.length(); i++) {
                    // 아스키코드 '0'은 48, 예를 들어 '1'(49)에서 '0'(48)을 빼면 1이 나옴.
                    int num1 = o1.charAt(i) - '0';
                    int num2 = o2.charAt(i) - '0';

                    // 0 ~ 9 사이의 정수라면 합한다.
                    if (num1 > 0 && num1 < 10) {
                        a += num1;
                    }
                    if (num2 > 0 && num2 < 10) {
                        b += num2;
                    }
                }
                // 3. 1, 2번 조건으로도 비교할 수 없으면 사전순으로 정렬한다.(오름차순)
                if (a == b) {
                    System.out.println(o1.compareTo(o2));
                    return o1.compareTo(o2);
                }
                return a - b;
            }
        });

        list.forEach(System.out::println);
    }
}

