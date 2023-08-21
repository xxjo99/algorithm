package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2606 {

    public static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);
            list.get(B).add(A);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        bfs(1);

        int count = 0;
        for (boolean b : visited) {
            if (b) {
                count++;
            }
        }

        System.out.println(count - 1);

    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i = 0; i < list.get(a).size(); i++) {
                int nextV = list.get(a).get(i);

                if (visited[nextV]) {
                    continue;
                }

                q.offer(nextV);
                visited[nextV] = true;
            }
        }

    }

}
