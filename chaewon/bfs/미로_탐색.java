package chaewon.bfs;

import java.io.*;
import java.util.*;

class Pair { // 좌표를 저장할 클래스
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 미로_탐색 {
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static Queue<Pair> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m]; // 미로를 저장할 배열
        visited = new boolean[n][m]; // 방문 여부를 저장할 배열

        // 미로를 만드는 과정
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = input.charAt(j) - '0'; // 1일 경우 : 49 - 48, 0일 경우 : 48 - 48
            }
        }

        bfs();
        System.out.println(maze[n-1][m-1]); // 배열의 가장 마지막 요소(== 최단거리) 출력
    }

    public static void bfs() {
        q = new LinkedList<>();
        q.offer(new Pair(0,0));
        int[][] position = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) { // 큐가 빌 때까지 반복
            Pair p = q.poll();

            // 상, 하, 좌, 우로 탐색
            for (int[] pos : position) {
                int nowX = p.x + pos[0];
                int nowY = p.y + pos[1];

                if (nowX < 0 || nowX >= n || nowY < 0 || nowY >= m) continue; // 이동한 좌표가 0보다 작거나 벽에 부딪히면 패스
                if (maze[nowX][nowY] == 0 || visited[nowX][nowY]) continue; // 0이거나 이미 방문한 좌표라면 패스

                // 위의 조건을 모두 통과한다면
                q.offer(new Pair(nowX,nowY)); // 큐에 이동한 좌표 삽입
                visited[nowX][nowY] = true; // 방문 체크
                maze[nowX][nowY] = maze[p.x][p.y] + 1; // 한 칸 이동했기 때문에 이동한 좌표에 그 전 좌표 + 1을 대입
            }
        }
    }
}
