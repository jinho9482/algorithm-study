import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PG_1 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String answer="";
        outer:
        for (int i = 0; i < participant.length; i++) {
            for (int j = 0; j < completion.length; j++) {
                if (participant[i].equals(completion[j])) continue;
                // 동명이인이 있는 것은 못 걸러준다.
                if (j == (completion.length - 1) && !completion[j].equals(participant[i]))   {
                    answer = participant[i];
                    break outer;
                }
            }
        }
        System.out.println(answer);

        //----------------------------------------------------------------------------------------

        // sort를 하게 되면 그 만큼 loop를 돌게 된다. (length 가 5라면 4+3+2+1, 총 10회 돈다.)

        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) System.out.println(participant[i]);
        }
        System.out.println(participant[participant.length-1]);

        //----------------------------------------------------------------------------------------

        // map을 돌리면 된다.
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) + 1); // default 값을 0으로 설정
        }
        for (int i = 0; i < participant.length; i++) {
            if (map.getOrDefault(participant[i], 0) == 0) {
                System.out.println(participant[i]);
                break;
            }
            map.put(participant[i], map.getOrDefault(participant[i], 0) - 1);
        }

    }
}
