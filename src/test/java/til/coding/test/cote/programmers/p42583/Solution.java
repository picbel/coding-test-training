package til.coding.test.cote.programmers.p42583;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        return answer;
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
