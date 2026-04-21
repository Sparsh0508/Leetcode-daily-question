class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i); 
            hm.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int res = 0;
        for (List<Integer> grp : hm.values()) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int idx : grp) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }
            for (int idx : grp) { 
                if (freq.getOrDefault(target[idx], 0) > 0) {
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                } else {
                    res++;
                }
            }
        }

        return res;
    }
}
class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}