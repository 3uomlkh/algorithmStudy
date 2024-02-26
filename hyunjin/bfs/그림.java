package hyunjin.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 그림 {
    static int n, m; // 행과 열의 개수
    static int[][] arr;
    static boolean[][] check; // 방문 표시 확인
    static int[] dx; // 행 좌표
    static int[] dy; // 열 좌표
    static Queue<Node> queue; // 큐

    static int count, area, max;

    // readLine() 사용 위해 IOException
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        check = new boolean[n][m];

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        // 배열값 세팅
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static void bfs(int a , int b) {

        queue = new LinkedList<>();
        queue.add(new Node(a, b));
        check[a][b] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            area++;
            for (int k = 0; k < 4; k++) {
                int x = node.x + dx[k];
                int y = node.y + dy[k];

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                if (arr[x][y] == 1 && !check[x][y]) {
                    queue.offer(new Node(x, y));
                    check[y][y] = true;
                }
            }
        }
        if (area > max) {
            max = area;
        }

    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
