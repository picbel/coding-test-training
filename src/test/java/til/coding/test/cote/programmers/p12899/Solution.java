package til.coding.test.cote.programmers.p12899;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        StringBuilder answer = new StringBuilder();

        while(n > 0){
            int remainder = n % 3;
            n /= 3;

            if(remainder == 0) n--;

            answer.insert(0, numbers[remainder]);
        }

        return answer.toString();
    }

    @MethodSource
    @ParameterizedTest
    void verify(int n,String s){
        assertThat(solution(n)).isEqualTo(s);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of(1,"1"),
              Arguments.of(2,"2"),
              Arguments.of(3,"4"),
              Arguments.of(4,"11")
        );
    }

}
