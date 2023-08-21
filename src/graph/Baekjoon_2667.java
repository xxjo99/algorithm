package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon_2667 {

    public static int[][] arr;
    public static boolean[][] visit;
    public static int[] dirX = { 0, 0, -1, 1 };
    public static int[] dirY = { -1, 1, 0, 0 };

    public static int count = 0, number = 0;
    public static int nowX, nowY, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!visit[i][j] && arr[i][j] == 1) {
                    count = 0;
                    number++;
                    DFS(i, j);
                    list.add(count);
                }

            }
        }

        System.out.println(number);
        Collections.sort(list);
        for (int num : list) {
            System.out.println(num);
        }

    }

    static void DFS(int x, int y) {
        visit[x][y] = true;
        arr[x][y] = number;
        count++;

        for (int i = 0; i < 4; i++) {
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;

            if (rangeCheck() && !visit[nowX][nowY] && arr[nowX][nowY] == 1) {
                visit[nowX][nowY] = true;
                arr[nowX][nowY] = number;

                DFS(nowX, nowY);
            }
        }

    }

    static boolean rangeCheck() {
        return (nowX >= 0 && nowX < n && nowY >= 0 && nowY < n);
    }

}
