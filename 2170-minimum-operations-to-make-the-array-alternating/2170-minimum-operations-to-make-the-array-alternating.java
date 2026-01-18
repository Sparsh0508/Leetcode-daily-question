class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        HashMap<Integer, Integer> even = new HashMap<>();
        HashMap<Integer, Integer> odd = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            } else {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            }
        }
        
        int[] evenTop = getTopTwo(even);
        int[] oddTop = getTopTwo(odd);
        

        if (evenTop[2] != oddTop[2]) {
            
            return n - (evenTop[0] + oddTop[0]);
        } else {
            
            return Math.min(
                n - (evenTop[0] + oddTop[1]),
                n - (evenTop[1] + oddTop[0])
            );
        }
    }
    
    private int[] getTopTwo(HashMap<Integer, Integer> map) {
        int max1 = 0, max2 = 0;
        int val1 = -1;

        for (var entry : map.entrySet()) {
            int freq = entry.getValue();
            if (freq > max1) {
                max2 = max1;
                max1 = freq;
                val1 = entry.getKey();
            } else if (freq > max2) {
                max2 = freq;
            }
        }
        return new int[]{max1, max2, val1};
    }
}
