package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2579 {

    public static int[] stair;
    public static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        stair = new int[301];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        result = new int[301];
        result[1] = stair[1];
        result[2] = stair[1] + stair[2];
        result[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int i = 4; i <= n; i++) {
            result[i] = Math.max(result[i - 3] + stair[i - 1], result[i - 2]) + stair[i];
        }

        System.out.println(result[n]);
    }


}
