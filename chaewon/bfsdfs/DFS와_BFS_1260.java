package chaewon.bfsdfs;

import java.io.*;
import java.util.*;

public class DFS와_BFS_1260 {
    static int node, edge, start;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];
        str = new StringBuilder();

        for (int i = 0; i <= node; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        System.out.println(Arrays.deepToString(arr));
        dfs(start);
        System.out.println(str);

        for (int i = 0; i <= node; i++) {
            visited[i] = false;
        }
        str.setLength(0);
        bfs(start);
        System.out.println(str);
    }

    public static void dfs(int start) {
        str.append(start).append(" ");
        visited[start] = true;

        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        str.append(start).append(" ");

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= node; i++) {
                if (arr[now][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    str.append(i).append(" ");
                }
            }
        }
    }
}
