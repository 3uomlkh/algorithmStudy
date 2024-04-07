package chaewon.stack_queue;

import java.util.*;

public class 기능_개발 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < progresses.length; i++) {
            for (int j = progresses[i]; j < 100; j+=speeds[i]) {
                sum++;
            }
            q.add(sum); // 각 작업마다 남은 시간을 큐에 저장
            sum = 0;
        }

        int count = 0;
        int before = q.peek(); // 제일 앞에 있는 원소 저장
        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) { // 큐가 빌 때까지 비교 후 list에 count 저장
            if (q.peek() <= before) {
                count++;
                q.poll();
            } else {
                list.add(count);
                before = q.poll();
                count = 1;
            }
        }
        list.add(count); // 맨 마지막 요소의 count는 list에 저장되지 않고 while문에서 빠져나왔으므로 한 번 더 저장

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
