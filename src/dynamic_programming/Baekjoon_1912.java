package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1912 {

    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[n];
        dp = new Integer[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        recur(n - 1);
        System.out.println(max);

    }

    public static int recur (int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(recur(n - 1) + arr[n], arr[n]);
            max = Math.max(dp[n], max);
        }

        return dp[n];
    }

}
