package til.coding.test.cote.programmers.p60058;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] procession = processionFactory(rows, columns);
        int answerIndex = 0;
        for (int[] query : queries) {
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];

            List<Integer> list = new ArrayList<>();
            for (int i = y1; i < y2; i++) {
                list.add(getLocationValue(x1,i,procession));
            }
            for (int i = x1; i < x2; i++) {
                list.add(getLocationValue(i,y2,procession));
            }
            for (int i = y2; i > y1; i--) {
                list.add(getLocationValue(x2,i,procession));
            }
            for (int i = x2; i > x1; i--) {
                list.add(getLocationValue(i,y1,procession));
            }
            answer[answerIndex] = list.stream().min(Integer::compareTo).get();
            answerIndex++;
            Queue<Integer> q = new LinkedList<>();
            q.add(list.get(list.size()-1));
            list.remove(list.size()-1);
            q.addAll(list);
            for (int i = y1; i < y2; i++) {
                setLocationValue(x1,i,procession,q.poll());
            }
            for (int i = x1; i < x2; i++) {
                setLocationValue(i,y2,procession,q.poll());
            }
            for (int i = y2; i > y1; i--) {
                setLocationValue(x2,i,procession,q.poll());

            }
            for (int i = x2; i > x1; i--) {
                setLocationValue(i,y1,procession,q.poll());
            }

        }
        return answer;
    }

    int getLocationValue(int x,int y, int[][] procession){
        return procession[x-1][y-1];
    }
    void setLocationValue(int x,int y ,int[][] procession, int value){
        procession[x-1][y-1] = value;
    }

    private int xyCalculator(int x, int y,int columns){
        return ((x-1) * columns)+y;
    }

    private int[][] processionFactory(int rows, int columns) {
        int[][] procession = new int[rows][columns];
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                procession[x-1][y-1] = xyCalculator(x,y,columns);
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
