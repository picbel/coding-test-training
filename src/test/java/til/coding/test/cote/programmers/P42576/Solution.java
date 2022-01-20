package til.coding.test.cote.programmers.P42576;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/42576

//    @MethodSource
//    @ParameterizedTest
//    void solution(String[] participant, String[] completion) {
//        List<String> strings = new ArrayList<>(Arrays.asList(participant));
//        Arrays.stream(completion).forEach(strings::remove);
//        System.out.println(strings);
//        String answer = strings.stream().findFirst().get();
////        return answer;
//    }


//    getOrDefault 에 대하여 포스팅 하기 <- 지정된 키로 매핑된 값이 없는 경우 반환되어야 하는 기본값입니다.
//  getOrDefault(key, defaultValue) 값을 조회하는 key, 키로 조회후 값이 없는경우 해당 값을 리턴한다.

    @MethodSource
    @ParameterizedTest
    void solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String player : participant) hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        for(String player : completion) hashMap.put(player, hashMap.get(player) -1);

        for(Map.Entry<String, Integer> map: hashMap.entrySet()) {
            if(map.getValue() != 0) {
                answer = map.getKey();
                System.out.println(answer);
                break;
            }
        }
    }

    static Stream<Arguments> solution(){
        return Stream.of(
            Arguments.of(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}),
            Arguments.of(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}),
            Arguments.of(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"})
        );
    }


}
