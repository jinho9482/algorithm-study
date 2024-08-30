import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BJ_11726 {
    public static void main(String[] args) throws IOException {
        // 가로로 된 직사각형(길이 2짜리)가 0개일때 -> 1개
        // n이 짝수일 때, n/2개 까지 들어갈 수 있다.
        // n이 홀수일 때도 동일 (n/2는 소수점 버리고 int로 들어감)

        // 1개일 때, (n-1)가지
        // 2개일 때, (
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n/2; i++) {
            answer += combi(n-1, i);
        }
        System.out.println(answer % 10007);

    }
    public static long combi(int n, int m) {
        long up = 1;
        for (int i = 0; i < m; i++) {
            up *= n;
            n--;
        }
        long down = 1;
        for (int j = 2; j <= m; j++) {
            down *= j;
        }
        return up/down;
    }
}
