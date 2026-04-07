class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Set<Long> set = new HashSet<>();
        for (long x : prefix) {
            set.add(x);
            set.add(x - lower);
            set.add(x - upper);
        }

        List<Long> list = new ArrayList<>(set);
        Collections.sort(list);
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        int size = list.size();
        int[] tree = new int[4 * size];

        int result = 0;
        for (long x : prefix) {
            int left = map.get(x - upper);
            int right = map.get(x - lower);

            result += query(tree, 0, size - 1, left, right, 1);
            int index = map.get(x);
            update(tree, 0, size - 1, index, 1, 1);
        }

        return result;
    }

    private void update(int[] tree, int start, int end, int index, int val, int node) {
        if (start == end) {
            tree[node] += val;
            return;
        }

        int mid = (start + end) / 2;
        if (index <= mid) {
            update(tree, start, mid, index, val, 2 * node);
        } else {
            update(tree, mid + 1, end, index, val, 2 * node + 1);
        }

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    private int query(int[] tree, int start, int end, int l, int r, int node) {
        if (r < start || end < l) return 0;

        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;

        return query(tree, start, mid, l, r, 2 * node) +
               query(tree, mid + 1, end, l, r, 2 * node + 1);
    }
}