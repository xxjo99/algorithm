package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2178 {

    static int[][] map;
    static int n, m;

    static boolean[][] visited;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(map[n - 1][m - 1]);
    }

    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = xy[0] + dx[i];
                int nextY = xy[1] + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || visited[nextX][nextY]
                        || map[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new int[] { nextX, nextY });
                visited[nextX][nextY] = true;
                map[nextX][nextY] = map[xy[0]][xy[1]] + 1;

            }

        }

    }

}
