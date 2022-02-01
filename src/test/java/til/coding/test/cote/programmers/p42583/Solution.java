package til.coding.test.cote.programmers.p42583;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    // 문제가 개판
    public int solution(int bridge_length, int weight, int[] truck_weights) {
//        int answer = 0;
        Bridge bridge = new Bridge(bridge_length, weight);
        Queue<Integer> truck = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            truck.add(truck_weight);
        }

        int count = 0;
        while (!truck.isEmpty()){
            bridge.goTruck();
            count++;
            Integer truckWeight = truck.peek();
            if (bridge.isGo(truckWeight)){
                bridge.goTruck(truckWeight);
                truck.remove();
//                bridgeQ.add(truckWeight);
            }

        }
        System.out.println(count*bridge_length);


        return bridge_length+count;
    }

    class Bridge {
        final int bridgeLength;
        final int limitWeight;
        int nowWeight = 0;
        Queue<Integer> q = new LinkedList<>();

        void goTruck(int truckWeight){
            nowWeight += truckWeight;
            q.add(truckWeight);
        }

        void goTruck(){
            if (!q.isEmpty()){
                nowWeight = nowWeight - q.poll();
            }
        }

        boolean isGo(int truckWeight){
            return (nowWeight+truckWeight <= limitWeight) && q.size() <= bridgeLength;
        }

        public Bridge(int bridgeLength, int limitWeight) {
            this.bridgeLength = bridgeLength;
            this.limitWeight = limitWeight;
        }
    }

    @MethodSource
    @ParameterizedTest
    void verify(int bridge_length, int weight, int[] truck_weights,int answer){
        assertThat(solution(bridge_length,weight,truck_weights)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
            Arguments.of(2,10,new int[]{7,4,5,6},8),
            Arguments.of(100,100,new int[]{10},101),
            Arguments.of(100,100,new int[]{10,10,10,10,10,10,10,10,10,10},110)
        );
    }

}
