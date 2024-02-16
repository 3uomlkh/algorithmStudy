package chaewon.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
        boolean[] visited = new boolean[graph.length + 1]; // 방문처리를 위한 boolean 배열
        System.out.println(bfs(1, graph, visited));
    }

    private static String bfs(int start, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder(); // 탐색 순서 출력하기 위한 용도
        Queue<Integer> queue = new LinkedList<>(); // BFS에 사용할 큐 생성

        queue.offer(start); // 큐에 BFS를 시작할 노드 번호 삽입
        visited[start] = true; // 시작 노드 방문 처리

        while(!queue.isEmpty()) {
            int nodeIndex = queue.poll();  // 큐에서 꺼낸 노드 저장
            sb.append(nodeIndex).append(" -> ");
            // 큐에서 꺼낸 노드와 연결된 노드 체크
            for (int i = 0; i < graph[nodeIndex].length; i++) {
                int temp = graph[nodeIndex][i]; // 노드 nodeIndex번에 연결된 노드 저장
                if (!visited[temp]) { // 연결된 노드 중 방문하지 않은 노드라면
                    visited[temp] = true; // 해당 노드 방문 처리
                    queue.offer(temp); // 큐에 해당 노드 번호 삽입
                }
            }
        }
        return sb.toString(); // 탐색 순서 리턴
    }
}
