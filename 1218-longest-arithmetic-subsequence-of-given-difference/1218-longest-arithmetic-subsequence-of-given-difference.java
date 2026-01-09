class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int x : arr) {
            int prev = x - diff;
            int currLen = dp.getOrDefault(prev, 0) + 1;
            dp.put(x, currLen);
            ans = Math.max(ans, currLen);
        }

        return ans;
    }
}
