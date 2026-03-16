import java.util.*;
public class topologicalSort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            graph.get(u).add(v);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(graph, visited, st, i);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }
    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> st, int src){
        visited[src] = true;
        for(int nbr : graph.get(src)){
            if(!visited[nbr]){
                dfs(graph, visited, st, nbr);
            }
        }
        st.push(src);
    }
}
