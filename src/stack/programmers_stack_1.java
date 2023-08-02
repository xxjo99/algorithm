package stack;

import java.util.ArrayList;
import java.util.List;

public class programmers_stack_1 {

    public int[] solution(int[] arr) {
        List<Integer> answerList = new ArrayList<>();
        answerList.add(arr[0]);

        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != answerList.get(count)) {
                answerList.add(arr[i]);
                count++;
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

}
