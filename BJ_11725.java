import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11725 {
    static boolean[] visited;
    static Map<Integer, Integer> map = new HashMap<>();
    static List<int[]> temp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        visited[1] = true;
        for (int i = 0; i < n-1; i++) {
            String[] line = br.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]);
            int node2 = Integer.parseInt(line[1]);
            int parent = 0;
            int child = 0;

            if (visited[node1]) {
                parent = node1;
                child = node2;
                visited[child] = true;
                map.put(child, parent);
            } else if (visited[node2]) {
                parent = node2;
                child = node1;
                visited[child] = true;
                map.put(child, parent);
            } else {
                int[] tempNodes = {node1, node2};
                temp.add(tempNodes);

            }

            // 판별 불가한 애들을 검증한다.
            if (!temp.isEmpty()) {
                for (int[] x : temp) {
                    if (visited[x[0]]) {
                        parent = x[0];
                        child = x[1];
                        visited[child] = true;
                        map.put(child, parent);
                        temp.remove(x);

                    } else if (visited[x[1]]) {
                        parent = x[1];
                        child = x[0];
                        visited[child] = true;
                        map.put(child, parent);
                        temp.remove(x);
                    }
                }
            }


        }

        for (int key = 2; key <= n; key++) {
            System.out.println(map.get(key));
        }

    }
//    public static void bfs() {
//        Queue<Integer[]> queue = new LinkedList<>();
//        queue.add(new Integer[]{1,-1});
//        while (!queue.isEmpty()) {
//            Integer[] poll = queue.poll();
//            if(parents[poll[0]] != 0) continue;
//            parents[poll[0]] = poll[1];
//            List<Integer> integers = map.get(poll[0]);
//            for (Integer i : integers)
//                queue.add(new Integer[]{i, poll[0]});
//        }
//    }
}
