package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon_18870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sortedArr = new int[n];

        StringTokenizer  st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            // 정렬할 배열과 원본 배열에 값을 넣어준다.
            sortedArr[i] = arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (int i : sortedArr) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : arr) {
            int ranking = hashMap.get(key);	// 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);

    }

}
