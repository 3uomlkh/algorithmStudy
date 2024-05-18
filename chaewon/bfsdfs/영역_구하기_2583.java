package chaewon.bfsdfs;

import java.io.*;
import java.util.*;

public class 영역_구하기_2583 {
    static int h, w, k, size;
    static int[][] arr;
    static ArrayList<Integer> sizeResult;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        sizeResult = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            // 그림이 그려진 공간을 1로 채우기
            for (int y = ly; y < ry; y++) {
                for (int x = lx; x < rx; x++) {
                    arr[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == 0) { // 그림이 그려지지 않았다면 dfs
                    size = 1;
                    dfs(i, j);
                    sizeResult.add(size);
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(sizeResult);
        StringBuilder sb = new StringBuilder();

        // 영역의 개수 == 사이즈를 담은 ArrayList의 크기
        sb.append(sizeResult.size()).append("\n");
        for (Integer size : sizeResult) {
            sb.append(size).append(" ");
        }

        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        arr[x][y] = 1; // 영역에 들어온 것을 표시하기 위해 1로 바꿈

        for (int i = 0; i < 4; i++) { // 상, 하, 좌, 우를 돌며 영역 체크
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX < 0 || nowX >= h || nowY < 0 || nowY >= w) continue;
            if (arr[nowX][nowY] == 0) { // 영역이 비어있다면
                size++; // 사이즈를 하나 증가시키고 다시 dfs
                dfs(nowX, nowY);
            }
        }
    }
}
