package hyunjin.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 영역_구하기 {
    public static int M, N, K;
    public static int[][] arr;
    public static BufferedReader br;
    public static StringTokenizer st;
    public static int scale;
    public static ArrayList<Integer> scaleResult;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // y
        N = Integer.parseInt(st.nextToken()); // x
        K = Integer.parseInt(st.nextToken()); // 직사각형 수

        // 주어진 값에 만족하는 크기의 모눈종이에서 진행된다
        // 따라서 (N, M) 좌표에서는 내부 확인 할 필요 없기 때문에 0 ~ N-1, 0 ~ M-1을 영역으로 한다.
        arr = new int[N][M];
        scaleResult = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            // 입력받은 색칠 영역에 해당하는 좌표 배열에 1로 표시
            for (int x = startX; x < endX; x++) {
                for (int y = startY; y < endY; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    scale = 1;
                    dfs(i, j);
                    scaleResult.add(scale);
                }
            }
        }

        Collections.sort(scaleResult);

        System.out.println(scaleResult.size());
        for (int i = 0; i < scaleResult.size(); i++) {
            System.out.print(scaleResult.get(i) + " ");
        }
    }

    public static void dfs(int x, int y) {
        arr[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (X >= 0 && X < N && Y >= 0 && Y < M) {
                if (arr[X][Y] == 0) {
                    scale++;
                    dfs(X, Y);
                }
            }
        }
    }
}
