import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2579 {
    public static void main(String[] args) throws IOException {

        // 마지막 계단은 무조건 계산에 포함된다.

        // 마지막 계단까지 가는 경우의 수를 따진다.
        // 그 중에서 최고의 합을 구한다.

        // 합의 최대값을 구한다.
        // 그 중에서 마지막 계단가지 갈 수 있는지 따진다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] scores = new int[len];
        for (int i = 0; i < len; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[i] = score;
        }
        int step = 0;
        int maxSum = scores[len-1];
        int count = 0;
        int index = 0;
        while(true) {

        }


    }
}
