import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

//public class BJ_1010 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine());
//        for (int i = 0; i < num; i++) {
//            String[] line = br.readLine().split(" ");
//            int n = Integer.parseInt(line[0]);
//            int m = Integer.parseInt(line[1]);
//            System.out.println(combination(n,m));
//        }
//    }
//
//    public static long factorial(long n) {
//        long answer = 1;
//        for (long i = 2; i <= n; i++) {
//            answer *= i;
//        }
//        return answer;
//    }
//
//    public static long combination(long n,long m) {
//        long up = 1;
//        for (int i = 0; i < n; i++) {
//            up *= m;
//            m--;
//        }
//
//        long down = factorial(n);
//
//        return up/down;
//    }
//
//}

public class BJ_1010 {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            System.out.println(combi(Integer.parseInt(s[1]), Integer.parseInt(s[0])));
        }
    }
    public static int combi(int n, int m){
        if(n == m || m == 0) return dp[n][m] = 1;
        if(dp[n][m]!=0) return dp[n][m];
        return dp[n][m] = combi(n - 1, m - 1) + combi(n - 1, m);
    }
}
// 아래 문제 함 풀어보기
// 2 X n 타일링
// 평범한 배낭
