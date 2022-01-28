package til.coding.test.cote.programmers.p42579;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, genreBundle> musicMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreBundle bundle = musicMap.getOrDefault(genres[i], new genreBundle(genres[i]));
            bundle.addList(plays[i],i);
            musicMap.put(genres[i],bundle);
        }

        List<genreBundle> bundles = new ArrayList<>();
        for (Map.Entry<String, genreBundle> BundleEntry : musicMap.entrySet()) {
            bundles.add(BundleEntry.getValue());
        }

        bundles.sort(Collections.reverseOrder());
        for (genreBundle bundle : bundles) {
            bundle.musicSort();
            bundle.addAnswer(answer);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public class genreBundle implements Comparable<genreBundle> {
        public genreBundle(String genre) {
            this.genre = genre;
        }

        private final String genre;

        private Integer totalPlay = 0;
        private final List<Music> musicList = new ArrayList<>();

        public void addList(int play, int id){
            Music music = new Music(genre,play,id);
            musicList.add(music);
            totalPlay += play;
        }
        public void musicSort() {
            musicList.sort(Collections.reverseOrder());
            System.out.println(musicList);
        }

        @Override
        public int compareTo(genreBundle genreBundle) {
            if (genreBundle.totalPlay < totalPlay) {
                return 1;
            } else if (genreBundle.totalPlay > totalPlay) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "genreBundle{" +
                    "genre='" + genre + '\'' +
                    ", totalPlay=" + totalPlay +
//                    ", musicList=" + musicList +
                    '}';
        }

        public void addAnswer(List<Integer> answer) {
            if (musicList.size() == 1){
                answer.add(musicList.get(0).id);
            }else{
                answer.add(musicList.get(0).id);
                answer.add(musicList.get(1).id);
            }
        }
    }

    public class Music implements Comparable<Music>{
        private final String genre;
        private final int play;
        private final int id;

        public Music(String genre, int play, int id) {
            this.genre = genre;
            this.play = play;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Music{" +
                    "genre='" + genre + '\'' +
                    ", play=" + play +
                    ", id=" + id +
                    '}';
        }

        @Override
        public int compareTo(Music o) {
            if (o.play < play) {
                return 1;
            } else if (o.play > play) {
                return -1;
            }
            return 0;
        }
    }

    @MethodSource
    @ParameterizedTest
    void verify(String[] genres, int[] plays , int[] answer){
        assertThat(solution(genres,plays)).isEqualTo(answer);
    }

    static Stream<Arguments> verify(){
        return Stream.of(
            Arguments.of(new String[]{"classic", "pop", "classic", "classic", "pop"},new int[]{500, 600, 150, 800, 2500},new int[]{4, 1, 3, 0})
        );
    }

}
