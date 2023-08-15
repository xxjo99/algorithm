package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_24445 {

    public static int[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);
            list.get(B).add(A);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        bfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        q.offer(start);
        visited[start] = cnt++;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i = 0; i < list.get(a).size(); i++) {
                int nextV = list.get(a).get(i);

                if (visited[nextV] != 0) {
                    continue;
                }

                q.offer(nextV);
                visited[nextV] = cnt++;
            }
        }

    }

}
