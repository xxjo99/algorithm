package stack;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_stack_3 {

    class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        int currentWeight = 0;
        int index = 0 ;
        int time = 0;

        while (index < truck_weights.length) {
            time++;

            if (!bridge.isEmpty() && time - bridge.peek().time == bridge_length) {
                Truck truck = bridge.poll();
                currentWeight -= truck.weight;
            }

            if (bridge.size() >= bridge_length) {
                continue;
            }

            if (currentWeight + truck_weights[index] > weight) {
                continue;
            }

            currentWeight += truck_weights[index];
            bridge.add(new Truck(truck_weights[index], time));

            index++;
        }

        return time + bridge_length;
    }
}
