package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.add(new int[]{j, importance});
            }

            int count = 0;
            while (!queue.isEmpty()) {

                int[] now = queue.poll();
                boolean able = true;

                for (int[] q : queue) {
                    if (q[1] > now[1]) {
                        able = false;
                        break;
                    }
                }

                if (able) {
                    count++;
                    if (now[0] == m) {
                        break;
                    }
                } else {
                    queue.add(now);
                }
            }

            System.out.println(count);
        }

    }
}
