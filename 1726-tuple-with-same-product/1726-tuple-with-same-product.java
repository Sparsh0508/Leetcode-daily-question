class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < nums.length; i++)
            for (int j = i+1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                ans += 8 * hm.getOrDefault(product, 0);
                hm.put(product, hm.getOrDefault(product, 0) + 1);
            }

        return ans;
    }
}