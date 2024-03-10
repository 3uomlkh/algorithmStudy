package chaewon.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
    }

    public  static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] strArr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strArr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (a+b).compareTo(b+a);
            }
        });

        // 람다식으로도 표현할 수 있음
//        Arrays.sort(strArr, (a, b) -> (a+b).compareTo(b+a));

        if (strArr[0].equals("0")) return "0";

        for (String s : strArr) answer.append(s);

        return answer.toString();
    }
}
