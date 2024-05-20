package chaewon.bfsdfs;

import java.io.*;
import java.util.*;

public class 바이러스_2606 {
    // DFS
    static boolean[] check;
    static int[][] arr;
    static int count = 0;
    static int node, edge;

    // BFS
    static Queue<Integer> q = new LinkedList<Integer>();
    static int[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine()); // 노드의 수(= 컴퓨터의 수)
        edge = Integer.parseInt(br.readLine()); // 간선의 수(= 서로 연결되어있는 네트워크의 수)

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];
//        visited = new int[node + 1];

        for (int i = 0; i < edge; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
//        System.out.println(Arrays.deepToString(arr));

        // DFS로 구하기
        dfs(1);
        System.out.println(count - 1);

        // BFS로 구하기
//        bfs(1);
//        System.out.println(cnt);
    }

    public static void dfs(int start) {
        check[start] = true;
        count++;
//        System.out.println(Arrays.toString(check));

        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i])
                dfs(i);
        }

    }

    public static void bfs(int start) {
        q.offer(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 0; i < node; i++) {
                if (arr[current][i] == 1 && visited[i] == 0) {
                    q.offer(i);
                    visited[i] = 1;
                    cnt++;
                }
            }
        }
    }
}