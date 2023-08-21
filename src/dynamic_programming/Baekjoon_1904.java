package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1904 {

    static Integer[] dp = new Integer[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(recur(n));
    }

    public static int recur(int n) {

        if (dp[n] == null) {
            dp[n] = (recur(n - 1) + recur(n-2)) % 15746;
        }

        return dp[n];

    }

}
