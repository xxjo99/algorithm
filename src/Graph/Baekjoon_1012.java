package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1012 {

    static int[][] ground;
    static boolean[][] check;

    static int w;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            ground = new int[w][m];
            check = new boolean[w][m];

            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[x][y] = 1;
            }

            int count = 0;
            for (int j = 0; j < w; j++) {
                for (int l = 0; l < m; l++) {
                    if (ground[j][l] == 1 && !check[j][l]) {
                        BFS(j, l);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});
        check[startX][startY] = true;

        int[] X = {0, 0, -1, 1};
        int[] Y = {-1, 1, 0, 0};

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = poll[0] + X[i];
                int y = poll[1] + Y[i];

                if (x < 0 || x >= w || y < 0 || y >= m) {
                    continue;
                }

                if (ground[x][y] == 1 & !check[x][y]) {
                    queue.offer(new int[]{x, y});
                    check[x][y] = true;
                }
            }
        }
    }

}
