package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2108 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            sum += value;
        }
        Arrays.sort(arr);

        int count = 0;
        int max = -1;
        int mod = arr[0];
        boolean check = false;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                count = 0;
            }

            if (max < count) {
                max = count;
                mod = arr[i];
                check = true;
            } else if (max == count && check) {
                mod = arr[i];
                check = false;
            }
        }

        System.out.println((int) Math.round((double) sum / n));
        System.out.println(arr[n / 2]);
        System.out.println(mod);
        System.out.println(arr[n - 1] - arr[0]);
    }

}
