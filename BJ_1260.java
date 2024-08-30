import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1260 {
    static Map<Integer, List<Integer>> map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m,v;
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        v = Integer.parseInt(str[2]);
        // {1, [2,3,4]} {2, [4]} {3, [4]} {4, []} Map<parent, children>
        // 1번 아래는 234, 2번 아래는 4, 3번 아래는 4, 4번 아래는 비어있다.

        // 첫째 줄에 DFS를 수행한 결과를, stack
        // node input
        map = new HashMap<>();
        visited = new boolean[1000 + 1]; // 0,1,2,3,4
//        visited[1000] = true;
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int parent = Integer.parseInt(str[0]);
            int child = Integer.parseInt(str[1]);

            List<Integer> parentList = map.getOrDefault(parent, new ArrayList<>());
            parentList.add(child);
            map.put(parent, parentList);
            List<Integer> childList = map.getOrDefault(child, new ArrayList<>());
            childList.add(parent);
            map.put(child, childList);
        }
//        System.out.println(map);
        dfs(v);

        visited = new boolean[1000+1];
        System.out.println();
        bfs(v);

    }

    public static void dfs(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        List<Integer> children = map.get(node).stream().sorted().toList();
        for (Integer child: children) {
//          [2,3,4]
            if (!visited[child]) dfs(child);
        }

    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Integer parent = queue.poll(); // pop
            if(visited[parent]) continue;
            System.out.print(parent + " ");
            visited[parent] = true;
            List<Integer> children = map.get(parent).stream().sorted().toList();
            for (Integer child : children) {
                if(!visited[child]) queue.add(child);
            }
        }

    }
}
