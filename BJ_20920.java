import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_20920 {
    public static void main(String[] args) throws IOException {

//  1. 자주 나오는 단어일수록 앞에 배치한다.
//  2. 해당 단어의 길이가 길수록 앞에 배치한다.
//  3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
        // 먼저 각각의 단어를 count한다.
        // 갯수가 같으면 길이 비교
        // 길이까지 같으면 알파벳 순으로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String[] array = firstLine.split(" ");
        int num = Integer.parseInt(array[0]);
        int limit = Integer.parseInt(array[1]);
        Map<String, Integer> map = new HashMap<>();
        Set<String> keys = new HashSet<>();
        for (int i = 0; i < num; i++) {
            String line = br.readLine();
            keys.add(line);
            if (line.length() > limit) {
                map.put(line, map.getOrDefault(line, 0) + 1);
            }
        }

        int value = 0;
        List<String> list = new ArrayList<>();
        for (String j : keys) {
            if (map.get(j) > value) {
                list.add(j);
                value = map.get(j);
            }
            else if (map.get(j) < value) {
                list.addFirst(j);
            }
        }

    }
}
