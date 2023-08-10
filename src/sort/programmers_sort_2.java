package sort;

import java.util.Arrays;

public class programmers_sort_2 {

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] str = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        if (str[0].equals("0")) {
            return "0";
        }

        for(String s: str) {
            answer.append(s);
        }

        return answer.toString();
    }

}
