package chaewon.bfsdfs;

import java.io.*;
import java.util.*;

public class 특정_거리의_도시_찾기_18352 {
    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] visited;
    static int[] dist;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        visited = new int[N + 1];
        dist = new int[N + 1];
        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
            dist[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges.get(a).add(b);
        }

//        System.out.println(edges);
        bfs(X);

        check = false;
        for (int i = 0; i <= N; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) System.out.println(-1);

    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < edges.get(now).size(); i++) {
                int next = edges.get(now).get(i);
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
            System.out.println(Arrays.toString(dist));
        }
    }
}
