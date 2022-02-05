package til.coding.test.cote.programmers.p42747;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {
//    int average = (int) Arrays.stream(citations).average().orElse(0.0);
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = citations[citations.length-1];
        int h = 0;
        for (int m = 0; m < max; m++) {
            int count = 0;
            for (int citation : citations) {
                if (citation >= m) {
                    count++;
                }
                if (count >= m){
                    h = m;
                }
            }

        }
        return h;
    }

    @MethodSource
    @ParameterizedTest
    void verify(int[] citations, int answer){
        assertThat(solution(citations)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of(new int[]{3, 0, 6, 1, 5},3)
        );
    }

}
