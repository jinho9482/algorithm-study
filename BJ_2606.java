import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ_2606 {
    static boolean[] visited;
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(br.readLine());
        int net = Integer.parseInt(br.readLine());
        visited = new boolean[com + 1];

        int count = 0;
        visited[1] = true;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < net; i++) {
            String[] line = br.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]);
            int node2 = Integer.parseInt(line[1]);

            if (visited[node1]) {
                visited[node2] = true;

            } else if (visited[node2]) {
                visited[node1] = true;

            } else {
                list.add(new int[]{node1, node2});
            }

        }

        if (!list.isEmpty()) {
            for (int[] arr : list) {
                if (visited[arr[0]]) {
                    visited[arr[1]] = true;

                } else if (visited[arr[1]]) {
                    visited[arr[0]] = true;
                }
            }
        }

        System.out.println(Arrays.toString(visited));
        for (int x = 2; x < visited.length; x++) {
            if (visited[x]) count++;
        }

        System.out.println(count);

    }
}
