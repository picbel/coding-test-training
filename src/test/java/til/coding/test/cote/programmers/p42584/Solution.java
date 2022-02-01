package til.coding.test.cote.programmers.p42584;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                answer[i] = j-i;
                if(prices[i]>prices[j]) break;
            }
        }
        return answer;
    }

    @MethodSource
    @ParameterizedTest
    void verify(int[] prices, int[] answer){
        assertThat(solution(prices)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 2, 3},new int[]{4, 3, 1, 1, 0})
        );
    }

}
