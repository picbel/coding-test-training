package til.coding.test.cote.programmers.p42577;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {


//    https://programmers.co.kr/learn/courses/30/lessons/42577

    @MethodSource
    @ParameterizedTest
    void solution(String[] phone_book, boolean answer) {
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));
        boolean result = true;
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i-1])) {
                result = false;
                break;
            }
        }

        assertThat(answer).isEqualTo(result);

    }

    static Stream<Arguments> solution(){
        return Stream.of(
                Arguments.of(new String[]{"119", "97674223", "1195524421"}, Boolean.FALSE),
                Arguments.of(new String[]{"123","456","789"}, Boolean.TRUE),
                Arguments.of(new String[]{"12","123","1235","567","88"}, Boolean.FALSE)
        );
    }


}
