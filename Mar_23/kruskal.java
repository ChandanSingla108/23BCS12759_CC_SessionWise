import java.util.*;

public class kruskal {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 10}, {0, 2, 6}, {0, 3, 5}, {1, 3, 15}, {2, 3, 4}};
        int n = 4;
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        DSU dsu = new DSU(n);
        int minCost = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                minCost += weight;
            }
        }

        System.out.println("Minimum cost of the spanning tree: " + minCost);

    }

}
