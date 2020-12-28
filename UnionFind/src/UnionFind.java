/**
 * @author yanliu
 * @create 2020-12-29-0:01
 */
public class UnionFind {
    /**
     * using array to store the forest
     * parent[i] represent the index of parent i
     */
    private int[] parent;

    /**
     * store the weight of node i
     */
    private int[] size;

    /**
     * store the count the connectivity
     */
    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        count = n;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];

        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];

        }

        count--;
    }
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

    private int find(int x) {
        while (parent[x] != x) {
            // compress the path
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    public int getCount() {
        return count;
    }
}
