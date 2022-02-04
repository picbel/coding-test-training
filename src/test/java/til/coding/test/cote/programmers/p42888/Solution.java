package til.coding.test.cote.programmers.p42888;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String,String> userMap = new HashMap<>();
        for (String s : record) {
            String[] strings = s.split(" ");
            if (!"Leave".equals(strings[0])) {
                userMap.put(strings[1], strings[2]);
            }
        }

        for (String s : record) {
            String[] strings = s.split(" ");
            if ("Enter".equals(strings[0])) {
                answer.add(userMap.get(strings[1]) + "님이 들어왔습니다.");
            } else if ("Leave".equals(strings[0])) {
                answer.add(userMap.get(strings[1]) + "님이 나갔습니다.");
            }
        }
        return answer.toArray(new String[0]);
    }


    @MethodSource
    @ParameterizedTest
    void verify(String[] record, String[] answer){
        assertThat(solution(record)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
            Arguments.of(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}, new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."})
        );
    }

}
