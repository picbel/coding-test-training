package til.coding.test.cote.programmers.p42627;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class Solution {

    public int solution(int[][] jobs) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int totalTime = jobs[0][1];
        for (int i = 1; i < jobs.length; i++) {
            priorityQueue.offer(jobs[i][1]);
            totalTime -= jobs[i][0];
        }
//        for (int[] job : jobs) {
//            priorityQueue.offer(job[1]);
//        }

        while (!priorityQueue.isEmpty()){
            Integer burstTime = priorityQueue.poll();
            System.out.println("burstTime = "+burstTime);
            System.out.println("totalTime = "+totalTime);
            totalTime += totalTime + burstTime;
        }

        System.out.println("done totalTime = "+totalTime);
        return totalTime / jobs.length;
    }

    @MethodSource
    @ParameterizedTest
    void verify(int[][] jobs, int answer){
        assertThat(solution(jobs)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of(new int[][]{{0, 3}, {1, 9}, {2, 6}}, 9)
        );
    }

}
