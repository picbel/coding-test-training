package til.coding.test.cote.ch.p3;

//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public int solution(String s) {
        String answer = "";
        if (s.length() == 1) return 0;

        for (int start = 0; start <= s.length(); start++) {
            for (int i = 1; i <= 5; i++) {
                if (start+i > s.length()) break;

                String startStr = s.substring(start, start+i);
                String str = startStr;
                String remainStr = s.substring(start+i);
                while (true){
                    String nextInt = String.valueOf((Integer.parseInt(startStr)+1));
                    if (nextInt.length() > 5) break;
                    System.out.println("startStr = "+startStr+" / remainStr = "+remainStr);
                    if (remainStr.startsWith(nextInt)){
                        System.out.println("startStr = "+startStr+" / nextInt = "+nextInt);
                        str+=nextInt;
                        remainStr = remainStr.substring(nextInt.length());
                        System.out.println("남은 문자열 = " + remainStr);
                        startStr = nextInt;
                        System.out.println("strLength = "+str);

                    }else {
                        if (answer.length() < str.length() && str.length() > nextInt.length()) {
                            answer = str;
                            System.out.println("answer = "+str);
                        }
                        break;
                    }
                }
            }
        }

        return answer.length();
    }

    @MethodSource
    @ParameterizedTest
    void verify(String s,int answer){
        assertThat(solution(s)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of("8234235236239240",9),
              Arguments.of("123499100",5),
              Arguments.of("01020304",2),
              Arguments.of("999910000",9),
              Arguments.of("9999899999100000",10),
              Arguments.of("99999100000",9),
              Arguments.of("12356",3),
              Arguments.of("13579",0),
              Arguments.of("4",0)
        );
    }

}
