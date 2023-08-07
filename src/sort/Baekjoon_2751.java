package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2751 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] countingArr = new boolean[2000001];
        for (int i = 0; i < n; i++) {
            countingArr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < countingArr.length; i++) {
            if(countingArr[i]) {
                sb.append((i - 1000000)).append('\n');
            }
        }
        System.out.print(sb);

    }

}
