package til.coding.test.cote.programmers.P42586;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution2 {


//    https://programmers.co.kr/learn/courses/30/lessons/42586

    // 의식의 흐름버젼
    @MethodSource
    @ParameterizedTest
    void solution(int[] progresses, int[] speeds, int[] answer) {
        Queue<Task> list = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            list.add(new Task(progresses[i], speeds[i],i));
        }

        Task[] tasks = new Task[progresses.length];
        while (!list.isEmpty()){
            Task task = list.poll();
            if (task.isComplete()){
                tasks[task.index] = task;
            }else{
                task.proceed();
                list.add(task);
            }
        }

        System.out.println(Arrays.toString(tasks));
        List<Integer> answerList = new ArrayList<>();


//        while (!list.isEmpty()) {
//            for (Task task : list) {
//                task.proceed();
//                if (task.isComplete()){
//                    list.remove(task);
//                    q.add(task);
//                }
//            }
//        }





        assertThat(answer).isEqualTo(null);
    }

    class Task{
        int progress;
        int speeds;
        int index;
        int day = 0;

        public Task(int progress, int speeds, int index) {
            this.progress = progress;
            this.speeds = speeds;
            this.index = index;
        }

        void proceed(){
            day++;
            progress += speeds;
        }

        boolean isComplete(){
            return progress > 100;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return index == task.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }

        @Override
        public String toString() {
            return "Task{" +
                    "index=" + index +
                    ", day=" + day +
                    '}';
        }
    }

    static Stream<Arguments> solution(){
        return Stream.of(
                Arguments.of(new int[]{93, 30, 55},new int[]{1, 30, 5},new int[]{2, 1}),
                Arguments.of(new int[]{95, 90, 99, 99, 80, 99},new int[]{1, 1, 1, 1, 1, 1},new int[]{1, 3, 2})
        );
    }


}
