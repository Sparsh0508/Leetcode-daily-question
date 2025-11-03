class Solution {
    public int minCost(String colors, int[] time) {
        int ans = 0;
        int first = time[0];
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) 
            {
                ans += Math.min(first, time[i]);
                first = Math.max(first, time[i]);
            } 
            else 
            {
                first = time[i];
            }
        }
        return ans;
    }
}