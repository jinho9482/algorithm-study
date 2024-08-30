import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int row = Integer.parseInt(firstLine[0]);
        int col = Integer.parseInt(firstLine[1]);
        int[][] matrix = new int[row][col];
        // 길을 matrix로 만듦
        for (int i = 0; i < row; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0,0,1}); // y, x, count
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            if (poll[0]==row-1 && poll[1]==col-1) {
                System.out.println(poll[2]);
                break;
            }
            int y = poll[0];
            int x = poll[1];
            for (int [] d : directions) {
                if (y + d[0] >= 0 && y + d[0] < row && x + d[1] >= 0 && x+d[1] < col && matrix[y+d[0]][x+d[1]] == 1) {
//                    queue.add(new Integer[] {y+d[0]}, x+d[1], poll[2]+1});
                }
            }
        }


        // 아래, 오른쪽으로 간다.

        // 막혀있으면 위로 올라간다.
    }
}
