/**
 * @author yanliu
 * @create 2020-12-29-0:01
 */
public class UnionFind {
    // the count of connectivity
    private int count;

    // use array to store the tree
    // store the index of the root of a node
    private int[] parent;

    // the weight of a node is the number of its children
    private int[] weight;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        weight = new int[n];

        // init the parent and weight array
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    /**
     * union the node with small weight to the large weight
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        // connect the smaller weight tree to the larger weight tree
        if (weight[rootP] < weight[rootQ]) {
            parent[rootP] = rootQ;
            weight[rootQ] += weight[rootP];

        } else {
            parent[rootQ] = rootP;
            weight[rootP] += weight[rootQ];
        }


        count--;
    }

    /**
     * return the root of x
     * @param x
     * @return
     */
    public int find(int x) {
        while (parent[x] != x) {
            // route compression
            // the height of the tree is as most 3
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    /**
     * detect whether two nodes are connected
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int getCount() {
        return count;
    }

}