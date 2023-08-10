package sort;

import java.util.Arrays;

public class programmers_sort_1 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] cmd = new int[3];

            System.arraycopy(commands[i], 0, cmd, 0, 3);

            int[] copy = Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]);
            Arrays.sort(copy);

            answer[i] = copy[cmd[2] - 1];
        }

        return answer;
    }

}
