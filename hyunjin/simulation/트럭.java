package hyunjin.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new ArrayDeque<Integer>();

        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        st = new StringTokenizer(br.readLine());
        int truck = Integer.parseInt(st.nextToken());

        int time = 0;
        int onBridgeWeight = 0;

        while (!bridge.isEmpty()) {
            time++;

            onBridgeWeight -= bridge.poll();
            if (onBridgeWeight + truck <= L) {
                bridge.add(truck);
                onBridgeWeight += truck;

                if (--N == 0) break;

                truck = Integer.parseInt(st.nextToken());
            } else {
                bridge.add(0);
            }
        }
        time += bridge.size();
        System.out.println(time);
    }
}
