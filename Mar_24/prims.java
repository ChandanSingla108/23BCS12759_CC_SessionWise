import java.util.*;
public class prims {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 6, 5},
            {10, 0, 0, 15},
            {6, 0, 0, 4},
            {5, 15, 4, 0}
        };
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int minCost = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{0, 0}); // {node, weight}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            minCost += weight;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && graph[node][i] != 0) {
                    pq.offer(new int[]{i, graph[node][i]});
                }
            }
        }

        System.out.println("Minimum cost of the spanning tree: " + minCost);
    }
}
