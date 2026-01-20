class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;

        // Brute Force
        // long max = 0;

        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         int min = Integer.MAX_VALUE;
        //         long sum = 0;

        //         for (int k = i; k <= j; k++) {
        //             min = Math.min(min, nums[k]);
        //             sum += nums[k];
        //         }

        //         max = Math.max(max, min * sum);
        //     }
        // }
        // return (int) max;

        // second Approach 

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        Stack<Integer> st = new Stack<>();
        long max = 0;
        long mod = 1_000_000_007;

        for (int i = 0; i <= n; i++) {
            long curr = 0;
            if(i == n){
                curr = 0;
            }else{
                curr = nums[i];
            }
            while (!st.isEmpty() && nums[st.peek()] > curr) {
                int idx = st.pop();
                int left = 0;
                if(st.isEmpty()){
                    left = 0;
                }else{
                    left = st.peek() + 1;
                }
                int right = i - 1;

                long sum = prefix[right + 1] - prefix[left];
                max = Math.max(max, sum * nums[idx]);
            }
            st.push(i);
        }

        return (int)(max % mod);
    }
}
