package hyunjin.stack_queue;

import java.util.*;

public class 기능_개발 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> q = new LinkedList<>();
        int[] day = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                day[i] = (100 - progresses[i]) / speeds[i];
            } else {
                day[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
            q.add(day[i]);
        }

        // System.out.println(q);

        int count = 0;
        int beforeNum = q.peek();

        // System.out.println(beforeNum);

        List<Integer> funcList = new ArrayList<>();

        while (!q.isEmpty()) {
            if (q.peek() <= beforeNum) {
                count++;
                q.poll();
            } else {
                funcList.add(count);
                count = 1;
                beforeNum = q.poll();
            }
        }
        funcList.add(count);

        answer = new int[funcList.size()];

        for (int i = 0; i < funcList.size(); i++) {
            answer[i] = funcList.get(i);
        }

        return answer;
    }
}
