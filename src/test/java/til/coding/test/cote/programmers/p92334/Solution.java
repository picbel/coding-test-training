package til.coding.test.cote.programmers.p92334;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

//    https://programmers.co.kr/learn/courses/30/lessons/92334?language=java

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        HashMap<String, Integer> idReportCountMap = new HashMap<>();
        HashMap<String, ArrayList<String>> idReports = new HashMap<>();
        for (String s : id_list) {
            idReports.put(s,new ArrayList<>());
        }
        for (String s : reportSet) {
            String[] strings = s.split(" ");
            String id = strings[0];
            String reportId = strings[1];
            idReports.get(id).add(reportId);
            idReportCountMap.put(reportId,idReportCountMap.getOrDefault(reportId,0)+1);
        }

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            int banReport = 0;
            for (String str : idReports.get(id)) {
                if (k <= idReportCountMap.get(str)){
                    banReport++;
                }
            }
            answer[i] = banReport;
        }

        return answer;
    }

    @MethodSource
    @ParameterizedTest
    void verify(String[] id_list, String[] report, int k,int[] answer){
        assertThat(solution(id_list,report,k)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
            Arguments.of(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},2 , new int[]{2,1,1,0}),
            Arguments.of(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},3 , new int[]{0,0})
        );
    }

}
