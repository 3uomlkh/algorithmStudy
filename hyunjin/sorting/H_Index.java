package hyunjin.sorting;

import java.util.Arrays;

public class H_Index {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int h = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
