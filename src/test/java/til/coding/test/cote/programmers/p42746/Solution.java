package til.coding.test.cote.programmers.p42746;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }
        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2)); // 이거 확인해보기
        StringBuilder answer = new StringBuilder();
        list.forEach(answer::append);
        return list.stream().findFirst().orElse("0").equals("0")?"0":answer.toString();
    }

    @MethodSource
    @ParameterizedTest
    void verify(int[] numbers, String answer){
        assertThat(solution(numbers)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of(new int[]{6, 10, 2}, "6210"),
              Arguments.of(new int[]{3, 30, 34, 5, 9}, "9534330")
        );
    }

}
