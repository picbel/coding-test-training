package til.coding.test.cote.programmers.p81301;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<String,String> numStr = new HashMap<>();
        numStr.put("zero","0");
        numStr.put("one","1");
        numStr.put("two","2");
        numStr.put("three","3");
        numStr.put("four","4");
        numStr.put("five","5");
        numStr.put("six","6");
        numStr.put("seven","7");
        numStr.put("eight","8");
        numStr.put("nine","9");
        for (Map.Entry<String, String> map : numStr.entrySet()) {
            s = s.replace(map.getKey(),map.getValue());
        }
        return Integer.parseInt(s);
    }


    @MethodSource
    @ParameterizedTest
    void verify(String s,int answer){
        assertThat(solution(s)).isEqualTo(answer);
    }
//    https://programmers.co.kr/learn/courses/30/lessons/81301
    static Stream<Arguments> verify(){
        return Stream.of(
            Arguments.of("one4seveneight",1478),
            Arguments.of("23four5six7",234567),
            Arguments.of("2three45sixseven",234567),
            Arguments.of("123",123)
        );
    }

}
