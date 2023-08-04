package stack;

import java.util.Stack;

public class programmers_stack_2 {

    public static boolean solution(String s) {
        boolean answer;

        Stack<Character> stk = new Stack<>();

        if (s.charAt(0) == ')') {
            stk.push(')');
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    stk.push('(');
                } else {
                    if (stk.empty()) {
                        stk.push(')');
                        break;
                    } else {
                        stk.pop();
                    }
                }
            }
        }

        answer = stk.empty();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
    }
}
