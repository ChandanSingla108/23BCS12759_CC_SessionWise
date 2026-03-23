import java.util.*;
public class DSU{
    int[] parent;
    int[] size;
    public DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int u){
        if(parent[u] == u){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    public void union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv){
            return;
        }
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
    public static void main(String[] args) {
        DSU dsu = new DSU(5);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);
        System.out.println(dsu.find(0)); // Output: 0
        System.out.println(dsu.find(1)); // Output: 0
        System.out.println(dsu.find(2)); // Output: 0
        System.out.println(dsu.find(3)); // Output: 3
        System.out.println(dsu.find(4)); // Output: 3
    }
}

