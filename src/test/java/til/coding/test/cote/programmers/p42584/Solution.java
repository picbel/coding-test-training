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
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            int nowPrice = prices[i];
            int count = 0;
            for (int j = i+1; j < prices.length; j++) {
                System.out.println("now = "+nowPrice+ " / price "+ prices[j]);
                if (!(nowPrice > prices[j])){
                    count++;
                }
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(i -> i).toArray();
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
