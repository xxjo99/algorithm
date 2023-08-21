package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1260 {

    static int[][] graph;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        checked = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        DFS(n, v);
        System.out.println();

        checked = new boolean[n + 1];
        BFS(n, v);

    }

    public static void BFS(int n, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        checked[v] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int i = 1; i <= n; i++) {
                if (graph[temp][i] == 1 && !checked[i]) {
                    queue.add(i);
                    checked[i] = true;
                }
            }
        }
    }

    public static void DFS(int n, int v) {

        checked[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i <= n; i++) {
            if (graph[v][i] == 1 && !checked[i]) {
                DFS(n, i);
            }
        }
    }

}
