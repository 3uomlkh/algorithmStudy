package chaewon.Implementation;

import java.io.*;
import java.util.*;

public class 트럭_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int l = Integer.parseInt(st.nextToken()); // 다리의 최대하중

        Queue<Node> truck = new LinkedList<>(); // 대기중인 트럭들
        int[] location = new int[n]; // 다리에서 빠져나오는 시간 확인용 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st.nextToken());
            // 각 인덱스와 트럭의 무게 저장
            truck.offer(new Node(i, weight));
        }

        Queue<Node> bridge = new LinkedList<>(); // 다리 위에 올라간 트럭들
        int count = 0;
        int sum = 0;

        while(!truck.isEmpty()) {
            Node a = truck.peek();
            int idx = a.index;
            int weight = a.weight;

            if (!bridge.isEmpty()) {
                int start = bridge.peek().index;

                for (int i = start; i < idx; i++) {
                    location[i]--;
                }
                if (location[start] == 0) {
                    sum -= bridge.poll().weight;
                }
            }

            // 다리에 있는 트럭의 무게 + 들어갈 트럭의 무게가 다리의 최대하중보다 작거나 같으면
            if (sum + weight <= l) {
                bridge.offer(truck.poll()); // 다음 트럭을 다리에 올리기
                sum += weight; // 전체 무게에 올라간 트럭의 무게 더하기
                location[idx] = w; // 올라간 트럭에 해당하는 인덱스에 다리의 길이를 대입
            }
            count++;
        }
        System.out.println(count + w);
    }
}
class Node {
    int index, weight;

    Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}