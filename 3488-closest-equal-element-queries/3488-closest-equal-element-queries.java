class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int qi : queries) {
            int idx = qi;
            int ele = nums[idx];

            List<Integer> arr = hm.get(ele);
            int sz = arr.size();

            if (sz == 1) {
                res.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(arr, idx);

            int ans = Integer.MAX_VALUE;
            int right = arr.get((pos + 1) % sz);
            int d = Math.abs(idx - right);
            int circular = n - d;
            ans = Math.min(ans, Math.min(d, circular));
            int left = arr.get((pos - 1 + sz) % sz);
            d = Math.abs(idx - left);
            circular = n - d;
            ans = Math.min(ans, Math.min(d, circular));

            res.add(ans);
        }

        return res;
    }
}