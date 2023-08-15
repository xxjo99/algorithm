package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_24480 {

    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] vertex;
    public static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int	r = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; ++i) {
            graph.get(i).sort((v1, v2) -> v2 - v1);
        }

        vertex = new int[n];
        count = 1;

        visited = new boolean[n];

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int ver : vertex) {
            sb.append(ver).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int u) {
        visited[u] = true;
        vertex[u] = count++;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

}
