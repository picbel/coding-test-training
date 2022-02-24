package til.coding.test.cote.ch.p2;

//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {
/*n
명의 사람이 순서대로 서 있고, 서 있는 사람들의 정보가 담긴 리스트 L이 주어집니다. 사람의 각 정보는 [h, p]로 표시됩니다. 즉 리스트 L은 2차원 배열 형태인 [[h1,p1],[h1,p1], ... ,[hk, pk], ... ,[hn, pn]] 형태로 주어지며, 첫 번째 원소는 첫 번째 사람의 정보를 나타내고, k번째 원소는 k번째 사람의 정보를 나타냅니다. [hk, pk]에서 hk는 k번째 사람의 키를 나타내며, pk는 k번째 사람의 앞에 서 있는 사람 중(첫 번째 사람부터 k-1번째 사람)에 k번째 사람보다 키가 크거나 같은 사람의 수를 나타냅니다.

예를 들어, 리스트 L의 초기 형태가 다음과 같을 때,

L = [[5,0], [7,0], [6,1], [5,3]]

첫 번째 원소 [5,0] : 첫 번째 사람의 키는 5(h1)이고, 첫 번째 사람보다 키가 크거나 같은 사람은 없으므로 0(p1)입니다.
두 번째 원소 [7,0] : 두 번째 사람의 키는 7(h2)이고, 두 번째 사람의 앞에 서 있는 사람 중에서 두 번째 사람보다 키가 크거나 같은 사람은 없으므로 0(p2)입니다.
세 번째 원소 [6,1] : 세 번째 사람의 키는 6(h3)이고, 세 번째 사람의 앞에 서 있는 사람 중에서 세 번째 사람보다 키가 크거나 같은 사람은 두 번째 사람 한 명이기 때문에 1(p3)입니다.
네 번째 원소 [5,3] : 네 번째 사람의 키는 5(h4)이고, 네 번째 사람의 앞에 서 있는 사람 중에서 네 번째 사람보다 키가 크거나 같은 사람은 첫 번째, 두 번째, 세 번째 사람 세 명이기 때문에 3(p4)입니다.
이때, 우리는 리스트 L의 원소들이 랜덤으로 섞여서 주어질 때, 리스트 L의 초기 형태를 찾아야 합니다. 예를 들어, L = [[7,0], [5,0], [5,3], [6,1]]이 주어졌을 때, 리스트 L의 초기 형태는 [[5,0], [7,0], [6,1], [5,3]]입니다.

리스트 L의 원소들이 랜덤으로 섞여서 주어질 때, 위와 같은 조건을 만족하는 리스트 L의 초기 형태를 찾아 return 하는 solution 함수를 완성해 보세요.

제한사항
n : 1000 이하의 자연수
h : 10,000 이하의 자연수
p : n보다 작은 정수(0 ≤ p < n)
리스트 L의 초기 형태(답)는 문제의 조건을 반드시 만족합니다. 예를 들어, [[5,0],[5,2]]와 같이 잘못된 답은 나오지 않습니다*/
    public int[][] solution(int[][] L) {
        int[][] answer = new int[L.length][];
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1]){
                return Integer.compare(o1[0], o2[0]);
            }else{
                return Integer.compare(o1[1], o2[1]);
            }
        }));


        for (int i = 0; i < L.length; i++) {
            q.offer(L[i]);
        }

        for (int i = 0; i < answer.length; i++) {
            int[] poll = q.poll();
            answer[i] =poll;
            list.add(poll);
        }

        boolean flag = false;
        do {
            for (int i = 0; i < list.size(); i++) {
                flag = false;

                int height = list.get(i)[0];
                int biggerCount= list.get(i)[1];
                int count = 0;
                for (int j = 0; j < i; j++) {
                    if (height <= list.get(j)[0]){
                        count++;
                    };
                }
//                for (int[] ints : list) {
//                    System.out.print(Arrays.toString(ints));
//                }
                if (!(biggerCount == count)){
                    count = 0;
                    System.out.println(Arrays.toString(list.get(i)));
                    for (int j = 0; j < i; j++) {
                        if (height <= list.get(j)[0]){
                            count++;
                        };
                        if (count== biggerCount){
                            int[] ints = list.get(i);
                            list.remove(ints);
                            list.add(i,ints);
                            flag = true;
                            break;
                        }
                    }

                }
            }

        }while (flag);
//        System.out.println(Arrays.deepToString(answer));
        return answer;
    }


    @MethodSource
    @ParameterizedTest
    void verify(int[][] L,int[][] answer){
        assertThat(solution(L)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
              Arguments.of(new int[][]{{7,0},{5,0},{5,3},{6,1}},new int[][]{{5,0},{7,0},{6,1},{5,3}}),
              Arguments.of(new int[][]{{3,2},{3,0},{3,1}},new int[][]{{3,0},{3,1},{3,2}}),
              Arguments.of(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}},new int[][]{{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}})
        );
    }

}
