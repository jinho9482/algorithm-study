import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;


public class BJ_11053 {
    public static void main(String[] args) throws IOException {
        // set 로 만들고

        // 오름차순

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String nums = br.readLine();
        String[] stringArr = nums.split(" ");
        List<Integer> source = new ArrayList<>();
        for (int i = 0; i < stringArr.length; i++) {
            source.add(Integer.parseInt(stringArr[i]));
        }

        int minValue = getMin(source);
        int maxValue = getMax(source);
        System.out.println(getMax(source));
        System.out.println(source.lastIndexOf(maxValue));
        List<Integer> list = new ArrayList<>();

        for (int j = 0; j < source.size(); j++) {
            if (source.get(j) == minValue && !list.contains(minValue)) list.add(source.get(j));
            if (!list.isEmpty()) {
                // 최대값이 처음에 나오면 안 먹힌다.
                if (source.get(j) == maxValue && j == source.lastIndexOf(maxValue)) {
                    list.add(source.get(j));
                    break;
                }
                if (source.get(j) > list.get(list.size()-1)) {
                    list.add(source.get(j));
                }
            }
        }
//        System.out.println(getMin(arr));
        System.out.println(list);
        System.out.println(list.size());

        // 10 20 15 10 20 이렇게 나왔을 경우
        // 먼저 10 20 15로 만들고 작은애들은 자른다.
        // 첫번 째 최소값, 마지막 최대값
    }

    public static int getMin(List<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) min = list.get(i);
        }
        return min;
    }

    public static int getMax(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) max = list.get(i);
        }
        return max;
    }

}
