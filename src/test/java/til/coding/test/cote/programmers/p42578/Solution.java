package til.coding.test.cote.programmers.p42578;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public int solution(String[][] clothes) {
        System.out.println(clothes.length);
        int answer = 0;
        return answer;
    }

    @MethodSource
    @ParameterizedTest
    void verify(String[][] clothes, int answer){
        assertThat(answer).isEqualTo(solution(clothes));
    }

    static Stream<Arguments> verify(){
        return Stream.of(
            Arguments.of(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}},5),
            Arguments.of(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}},3)
        );
    }
}
