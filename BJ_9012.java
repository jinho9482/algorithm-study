import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BJ_9012 {
    public static void main(String[] args) throws IOException {
        // () 가 pair로 나오지 않고 ) 이 나왔을 때
        // () 가 pair 로 나오지 않고 (이 나오고 끝났을 때
        // 전체적으로 ( , ) 갯수가 맞지 않을 떄

        // 우선 전체 길이가 홀 수 이면 no
        // 짝수 일 때, 가운데 2개 값이 () 이 아니면 no

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String firstLine = br.readLine();
//
//        outer:
//        for (int i = 0; i < Integer.parseInt(firstLine); i++) {
//            String restLine = br.readLine();
//            String[] array = restLine.split("");
//            int count = 0;
//            // 홀수 개는 무조건 NO
//            if (array.length % 2 == 1) {
//                System.out.println("NO");
//                continue;
//            }
//
//            // count가 -가 되면 무조건 NO
//            for (int j = 0; j < array.length; j++) {
//                if (array[j].equals("(")) count++;
//                else count--;
////                if (count < 0) System.out.println("NO");
//                if (count<0) break;
//            }
//            // 갯수가 맞으면 NO
//            if (count != 0) System.out.println("NO");
//            else System.out.println("YES");
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstLine = Integer.parseInt(br.readLine());

        for (int i = 0; i < firstLine; i++) {
            boolean emptyError = false;
            Stack<String> stack = new Stack<>();
            String[] arr = br.readLine().split("");
            for (String j : arr) {
                if (j.equals("(")) stack.push("(");
                else if (j.equals(")")) {
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        emptyError = true;
                        break;
                    }
                }
            }
            if(stack.isEmpty()&&!emptyError) System.out.println("YES");
            else System.out.println("NO");
        }


    }
}
