package til.coding.test.cote.programmers.P42586;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {


//    https://programmers.co.kr/learn/courses/30/lessons/42586

    // 의식의 흐름버젼
    @MethodSource
    @ParameterizedTest
    void solution(int[] progresses, int[] speeds, int[] answer) {
        ArrayList<Integer> solutionAnswer = new ArrayList<>();
        Queue<progressObj> progressQ = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            progressQ.add(new progressObj(progresses[i],speeds[i],i));
        }
        int count = 0;
        int deploymentIndex = 0;
        while (!progressQ.isEmpty()){
            progressObj peek = progressQ.poll();
            peek.progressing();
            if (!peek.isComplete()){
               if (count > 0){
                   solutionAnswer.add(count);
                   count = 0;
               }
                progressQ.add(peek);
            }else{
                if (deploymentIndex == peek.getIndex()){
                    count++;
                    deploymentIndex = peek.getIndex()+1;
                }else{
                    if (count > 0){
                        solutionAnswer.add(count);
                    }
                    count = 0;
                    progressQ.add(peek);
                }
            }
        }
        solutionAnswer.add(count);
        int[] ints = solutionAnswer.stream().mapToInt(i -> i).toArray();
        assertThat(answer).isEqualTo(ints);
    }
    class progressObj{
        int progress;
        int speed;
        int index;

        @Override
        public String toString() {
            return "progressObj{" +
                    "progress=" + progress +
                    ", speed=" + speed +
                    ", index=" + index +
                    '}';
        }

        public int getProgress() {
            return progress;
        }

        public int getSpeed() {
            return speed;
        }

        public int getIndex() {
            return index;
        }

        public progressObj(int progress, int speed, int index) {
            this.progress = progress;
            this.speed = speed;
            this.index = index;
        }

        void progressing(){
            this.progress = this.progress+speed;
        }

        boolean isComplete(){
            return progress >= 100;
        }
    }

    static Stream<Arguments> solution(){
        return Stream.of(
                Arguments.of(new int[]{93, 30, 55},new int[]{1, 30, 5},new int[]{2, 1}),
                Arguments.of(new int[]{95, 90, 99, 99, 80, 99},new int[]{1, 1, 1, 1, 1, 1},new int[]{1, 3, 2})
        );
    }


}
