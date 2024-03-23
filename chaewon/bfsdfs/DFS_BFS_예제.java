package chaewon.bfsdfs;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS_예제 {
    public static final int[] dx = {-1, 0, 1, 0};
    public static final int[] dy = {0, 1, 0, -1};
    private static final int LinkedList = 0;
    public static int map[][];
    public static boolean visit[][];
    public static int ans = Integer.MAX_VALUE;
    public static int N, M;
    public static Queue<Position> q;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("/User/won/study/algorithm/algorithmStudy/chaewon/bfsdfs/bfsdfs.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                dfs(i, j, 0);
//            }
//        }
        dfs(0, 0, 0);
//        bfs();
        System.out.println(ans);

    }

    public static void dfs (int row, int col, int cnt) {
        if (map[row][col] == 1) {
            ans = Math.min(cnt, ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (visit[nx][ny]) {
                continue;
            }

            visit[row][col] = true;
            dfs(nx, ny, cnt+1);
            visit[row][col] = false;
        }
    }

    public static void bfs() {
        q = new LinkedList<>();

        q.add(new Position(0, 0, 0));

        while (!q.isEmpty()) {
            Position pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.row + dx[i];
                int ny = pos.col + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (visit[nx][ny]) {
                    continue;
                }

                visit[nx][ny] = true;
                if (map[nx][ny] == 1) {
                    ans = pos.cnt + 1;
                    return;
                }

                q.add(new Position(nx, ny, pos.cnt + 1));
            }
        }
    }
}

class Position  {
    int row, col, cnt;
    public Position(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}
