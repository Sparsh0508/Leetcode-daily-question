class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;

        int[] freq = new int[n + 1]; 
        for (int num : nums) {
            if (num >= n || num < 1) return false; 
            freq[num]++;
        }
        for (int i = 1; i < n - 1; i++) {
            if (freq[i] != 1) return false;
        }
        if (freq[n - 1] != 2) return false;

        return true;
    }
}