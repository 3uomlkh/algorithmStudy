package chaewon.bfsdfs;

import java.io.*;
import java.util.*;

public class 적록색약_10026 {
    static int n;
    static String[][] painting;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        painting = new String[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "");
            for (int j = 0; j < n; j++) {
                painting[i][j] = st.nextToken();
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j, painting[i][j]);
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Objects.equals(painting[i][j], "G")) {
                    painting[i][j] = "R";
                }
            }
        }

        int countWeak = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j, painting[i][j]);
                    countWeak++;
                }
            }
        }

        System.out.println(count + " " + countWeak);



    }

    public static void dfs(int x, int y, String color) {
        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (visited[nx][ny] == 0 && Objects.equals(painting[nx][ny], color)) {
                dfs(nx, ny, color);
            }
        }
    }
}
