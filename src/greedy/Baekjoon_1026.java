package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] Aarr = new int[n];
        int[] Barr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Aarr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Barr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Aarr);
        Arrays.sort(Barr);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Aarr[i] * Barr[n-1-i];
        }

        System.out.println(sum);

    }
}
