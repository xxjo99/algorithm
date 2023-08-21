package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coinValue = new int[n];
        for (int i = 0; i < n; i++) {
            coinValue[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (coinValue[i] <= k) {
                result += k / coinValue[i];
                k = k % coinValue[i];
            }
        }

        System.out.println(result);
    }
}
