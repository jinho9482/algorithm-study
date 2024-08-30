import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_25206 {
    public static void main(String[] args) throws IOException {
        String[] grade = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double[] score = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0};
        double scoresSum = 0;
        double gradesSum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < grade.length; i++) {
            map.put(grade[i], score[i]);
        }

//        Map<String, Double> map1 = Map.of("A+", 4.5, "A0", 4.0, "B+", 3.5);

        for (int i = 0; i < 20; i++) {

            String line = br.readLine();
            String[] array = line.split(" ");
            if (array[2].equals("P")) continue;
            scoresSum += Double.parseDouble(array[1]) * map.get(array[2]);
            gradesSum += Double.parseDouble(array[1]);

        }
        System.out.println(scoresSum/gradesSum);

    }
}
