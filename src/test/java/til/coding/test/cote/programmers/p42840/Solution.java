package til.coding.test.cote.programmers.p42840;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public int[] solution(int[] answers) {
        List<Integer> solutionAnswer = new ArrayList<>();
        int[] giver = new int[]{0,0,0};

        for (int i = 0; i < answers.length; i++) {
            if (MathGiver.ONE.match(answers[i],i)){
                giver[0]++;
            }
            if (MathGiver.TWO.match(answers[i],i)){
                giver[1]++;
            }
            if (MathGiver.THREE.match(answers[i],i)){
                giver[2]++;
            }
        }
        int max = Arrays.stream(giver).max().orElse(0);
        for (int i = 0; i < giver.length; i++) {
            if (giver[i] == max) solutionAnswer.add(i+1);
        }
        return solutionAnswer.stream().mapToInt(i -> i).toArray();
    }

    enum MathGiver {
        ONE(1, new int[]{1, 2, 3, 4, 5}),
        TWO(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}),
        THREE(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        int id;
        int[] chopNumbers;

        MathGiver(int id, int[] chopNumbers) {
            this.id = id;
            this.chopNumbers = chopNumbers;
        }

        boolean match(int answer,int answerIndex){
            return answer == chopNumbers[indexCal(answerIndex)];
        }

        int indexCal(int i){
            return i < chopNumbers.length? i : i%chopNumbers.length;
        }
    }


    @MethodSource
    @ParameterizedTest
    void verify(int[] answers, int[] answer){
        assertThat(solution(answers)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of(new int[]{1,2,3,4,5},new int[]{1}),
              Arguments.of(new int[]{1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5},new int[]{1}),
              Arguments.of(new int[]{1,3,2,4,2},new int[]{1,2,3})
        );
    }

}
