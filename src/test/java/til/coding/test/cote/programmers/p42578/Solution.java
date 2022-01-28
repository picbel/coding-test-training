package til.coding.test.cote.programmers.p42578;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public int solution(String[][] clothes) {
        HashMap<String,Integer> categoryMap = new HashMap<>();
        for (String[] arrayStr : clothes) {
            String category = arrayStr[1];
            categoryMap.put(category,categoryMap.getOrDefault(category,0)+1);
        }
        int answer = 0;
        for (Map.Entry<String, Integer> map : categoryMap.entrySet()) {
            Integer value = map.getValue() + 1;
            if (answer == 0){
                answer = value;
            }else{
                answer = answer*value;
            }
        }
        return answer - 1; // 아무것도 착용하지않는 경우의 수 1

    }

    public int solution2(String[][] clothes) {
       return Arrays.stream(clothes)
               .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
               .values()
               .stream()
               .reduce(1L, (x, y) -> x * (y + 1))
               .intValue()-1;

    }

    @MethodSource
    @ParameterizedTest
    void verify(String[][] clothes, int answer){
        assertThat(answer).isEqualTo(solution(clothes));
        assertThat(answer).isEqualTo(solution2(clothes));
    }

    static Stream<Arguments> verify(){
        return Stream.of(
            Arguments.of(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}},5),
            Arguments.of(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}},3)
        );
    }
}
