package til.coding.test.cote.ch.p1;

//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {
/*두 가지 물품을 구매할 수 있도록 예산을 배정받았습니다, 첫 번째 물품의 가격은 a원, 두 번째 물품의 가격은 b원 입니다. 각 물품은 여러 개 구매할 수 있으며, 구매하지 않아도 괜찮습니다.

물품을 구매하는 여러 가지 방법 중, 예산을 남기지 않고 물품을 구매하는 방법의 수를 구하려 합니다. 예를 들어 예산이 23000원이고, 첫 번째 물품의 가격 a = 3000원, 두 번째 물품의 가격 b = 5000원인 경우, 예산에 딱 맞게 물건을 구매하는 방법은 다음과 같이 두 가지 방법이 있습니다.

첫 번째 물품을 1개(3000원), 두 번째 물품을 4개(20000원) 구매합니다.
첫 번째 물품을 6개(18000원), 두 번째 물품을 1개(5000원) 구매합니다.
위 두 가지 방법 외에 예산을 남기지 않고 물품을 구매할 수 있는 방법은 없습니다.

첫 번째 물품의 가격 a, 두 번째 물품의 가격 b, 예산 budget이 매개변수로 주어질 때, 예산을 남기지 않고 물품을 구매하는 방법의 가짓수를 return 하도록 solution 함수를 완성해주세요.

*/
    public int solution(int a,int b, int budget) {
        int answer = 0;
        int aLimit = budget/a;
        int bLimit = budget/b;
        System.out.println("aLimit = "+aLimit+ " / bLimit = "+bLimit);
        for (int ax = 0; ax <= aLimit; ax++) {
            if ((budget -(ax*a))%b == 0) answer++;
//            for (int by = 0; by <= bLimit; by++) {
//                int cal = budget -((ax*a) + (by*b));
//                if (cal< 0) break;
//                System.out.println(ax+""+by+" "+(budget -((ax*a) + (by*b))));
//                if (cal == 0){ answer++;}
//            }
        }

        return answer;
    }

    @MethodSource
    @ParameterizedTest
    void verify(int a,int b, int budget,int answer){
        assertThat(solution(a, b, budget)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of(3000,5000,23000,2),
              Arguments.of(3000,5000,23000,2)
        );
    }

}
