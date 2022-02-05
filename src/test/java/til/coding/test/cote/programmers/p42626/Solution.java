package til.coding.test.cote.programmers.p42626;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class Solution {

    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> scovilleQ = new PriorityQueue<>();
        for (int i : scoville) {
            scovilleQ.offer(i);
        }
        while (isNotComplete(scovilleQ,k)){
            if (scovilleQ.size() < 2){
                return -1;
            }
            answer++;
            Integer poll = scovilleQ.poll();
            Integer poll2 = scovilleQ.poll();
            int newScoville = poll + (poll2 * 2);
            scovilleQ.offer(newScoville);

        }
        return answer;
    }

    boolean isNotComplete(PriorityQueue<Integer> scovilleQ, int k){
        return !(scovilleQ.stream().mapToInt(i -> i).allMatch(i -> i >= k));
    }

    @MethodSource
    @ParameterizedTest
    void verify(int[] scoville, int k, int answer){
        assertThat(solution(scoville,k)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 9, 10, 12},7, 2)
        );
    }

}
