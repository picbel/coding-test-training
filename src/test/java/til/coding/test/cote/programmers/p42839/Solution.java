package til.coding.test.cote.programmers.p42839;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public int solution(String numbers) {
        int len = numbers.length();
        // String 배열로 숫자 하나씩 담아주기
        String[] str = new String[len];
        for(int i=0;i<len;i++){
            str[i] = Character.toString(numbers.charAt(i));
        }
        System.out.println(Arrays.toString(str));

        return 0;
    }

    boolean isPrime(int n) {
        for(int i = 2 ; i < n ; ++i){
            if(n % i == 0) return false;
        }
        return true;
    }

    //소수 찾기 n까지의 소수찾기
//    ArrayList<Integer> getPrimes(int n){
//        ArrayList<Integer> memo = new ArrayList<>();
//        memo.add(2);
//
//        for(int i = 2 ; i <= n ; ++i){
//            for(int j = 0 ; j < memo.size() ; ++j){
//                if(i % memo.get(j) == 0) break; // 소수로 나누어 떨어지면 소수가 아니다.
//                if((j + 1) == memo.size()) memo.add(i); // 이전까지의 모든 소수로 나누어 떨어지지 않으면 소수다.
//            }
//        }
//        return memo;
//    }


    @MethodSource
    @ParameterizedTest
    void verify(String numbers, int answer){
        assertThat(solution(numbers)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of("17",3),
              Arguments.of("011",2)
        );
    }

}
