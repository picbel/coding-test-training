package til.coding.test.cote.programmers.p42748;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int index = commands[i][2];
            List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList()).subList(start, end);
            Collections.sort(list);
            answer[i] = list.get(index-1);
        }
        return answer;
    }

    @MethodSource
    @ParameterizedTest
    void verify(int[] array, int[][] commands, int[] answer){
        assertThat(solution(array, commands)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}},new int[]{5,6,3})
        );
    }

}
