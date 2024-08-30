import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dynamic programming 대표
// 2가지
// bottom up
// top down


public class BJ_2747 {
    static int[] dp;
    public static void main(String[] args) throws IOException {

        // 아래에서 부터 시작한다. -> bottom up
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine());
        long first = 0;
        long second = 1;
        long x = 0L;

        if (limit == 1) {
            System.out.println(1);
        } else {
            for (int i = 2; i <= limit; i++) {
                x = first + second;
                first = second;
                second = x;
            }
            System.out.println(x);
        }

        // memoization (top-down)
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(fibo2(n));
    }

    // 위에서 부터 시작한다. -> top down
    // 계산한 걸 안하면 된다. -> memoization이라는 방법을 쓴다. (계산한 걸 기억한다, cache)
    public static int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fibo(n-1) + fibo(n-2);
    }

    public static int fibo2(int n) {
        if (n == 0 || n == 1 || dp[n]!=0) return dp[n];
        dp[n] = fibo2(n-1) + fibo2(n-2);
        return dp[n];
    }



}
