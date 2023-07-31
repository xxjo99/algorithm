package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stk = new Stack<>();

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                stk.pop();
            } else {
                stk.push(n);
            }
        }

        int result = 0;

        for (int i : stk) {
            result += i;
        }

        System.out.println(result);
    }

}
