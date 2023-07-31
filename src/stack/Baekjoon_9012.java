package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();

            Stack<Character> stk = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    stk.push(s.charAt(j));
                } else {
                    if (stk.empty()) {
                        stk.push(s.charAt(j));
                        break;
                    } else {
                        stk.pop();
                    }
                }
            }

            if (stk.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

}
