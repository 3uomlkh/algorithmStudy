package hyunjin.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질 {
    static int N;
    static int K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputs = input.split(" ");

        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        int result = bfs(N);
        System.out.println(result);
    }

    private static int  bfs(int node)
    {
        Queue<Integer> queue = new LinkedList<Integer>();

        // 처음 수빈이의 위치 큐에 넣고 방문 흔적 남기기 (0초 부터 시작)
        queue.add(node);
        int n = 0;
        visited[node] = 0;

        // 큐가 비어있지 않을때 반복
        while (!queue.isEmpty())
        {
            // 큐에서 맨 앞의 값 반환 후 삭제
            n = queue.remove();

            // 인덱스 값이 동생의 위치와 같다면
            if (n == K)
            {
                // 방문 흔적(몇 초 지났는지) 반환한다.
                return visited[n];
            }

            // 인덱스-1 값이 0보다 크고 해당 인덱스에 방문 흔적이 없을 경우
            if (n-1>=0 && visited[n-1] == 0)
            {
                // 해당 인덱스에 방문 흔적을 남기는데 이전 단계의 방문 흔적에서  +1 해준 값을 넣는다.
                // 이동 횟수를 파악하기 위함
                // 큐에 해당 인덱스 넣어준다.
                visited[n-1] = visited[n]+1;
                queue.add(n-1);
            }

            // 인덱스+1 값이 100000보다 작고 해당 인덱스에 방문 흔적이 없는 경우
            if (n+1 <= 100000 && visited[n+1] == 0)
            {
                // 해당 인덱스에 방문 흔적 남긴다. (이전 단계 흔적 +1)
                // 큐에 해당 인덱스 넣어준다.
                visited[n+1] = visited[n]+1;
                queue.add(n+1);
            }

            // 인덱스+2 값이 100000보다 작고 해당 인덱스에 방문 흔적이 없는 경우
            if (2*n <= 100000 && visited[2*n] == 0)
            {
                // 해당 인덱스에 방문 흔적 남긴다. (이전 단계 흔적 +1)
                // 큐에 해당 인덱스 넣어준다.
                visited[2*n] = visited[n] + 1;
                queue.add(2*n);
            }
        }
        return visited[n];
    }
}
