package til.coding.test.cote.programmers.p60058;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] procession = processionFactory(rows, columns);
        for (int[] ints : procession) {
            System.out.println(Arrays.toString(ints));
        }
        return answer;
    }

    private int xyCalculator(int x, int y,int rows){
        return ((x-1) * rows)+((y-1) + 1);
    }

    private int[][] processionFactory(int rows, int columns) {
        int[][] procession = new int[rows][columns];
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                procession[x-1][y-1] = xyCalculator(x,y,rows);
            }
        }
        return procession;
    }

    @MethodSource
    @ParameterizedTest
    void verify(int rows, int columns, int[][] queries,int[] answer){
        assertThat(solution(rows, columns, queries)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}},new int[]{8, 10, 25})
              ,Arguments.of(3,3,new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}},new int[]{1, 1, 5, 3})
              ,Arguments.of(100,97,new int[][]{{1,1,100,97}},new int[]{1})
        );
    }

}
