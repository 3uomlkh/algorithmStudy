package chaewon.bfs;

import java.io.*;
import java.util.*;

class Node { // 좌표를 저장할 클래스
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 그림 {
    static int n, m; // 행과 열의 개수
    static int[][] board; // 도화지
    static boolean[][] visited; // 방문한
    static int count; // 그림의 개수
    static int area; // 그림의 넓이
    static int max; // 그림의 최대 넓이
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        // 도화지에 그림을 그리는 과정
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) { // 1이면서 방문하지 않은 칸이라면 bfs 시작
                    bfs(i, j);
                }
            }
        }

        System.out.println(count); // 그림의 개수 출력
        System.out.println(max); // 그림의 최대 넓이 출력
    }

    public static void bfs(int x, int y) {
        area = 0;
        q = new LinkedList<>();
        q.add(new Node(x, y));
        int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) { // 큐가 빌 때까지 반복
            Node node = q.poll();
            area++;
            int nowX = node.x;
            int nowY = node.y;

            // 상, 하, 좌, 우로 탐색
            for (int[] p : pos) {
                int nx = nowX + p[0];
                int ny = nowY + p[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 좌표가 0보다 작거나 벽에 부딪히면 패스
                if (board[nx][ny] == 0 || visited[nx][ny]) continue; // 0이거나 이미 방문한 좌표라면 패스

                // 위의 조건을 모두 통과한다면
                visited[nx][ny] = true; // 방문 체크
                q.add(new Node(nx, ny)); // 큐에 삽입
            }
            System.out.println(area);
        }

        count++; // 그림의 개수 + 1
        if (area > 1) area--;
        max = Math.max(max, area); // 최대 넓이 구하기
    }
}
