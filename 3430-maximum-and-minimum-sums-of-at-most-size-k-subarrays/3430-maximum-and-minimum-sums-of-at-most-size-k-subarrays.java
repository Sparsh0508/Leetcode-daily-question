class Solution {
    public long minMaxSubarraySum(int[] nums, int k) {
        return minOrMaxSum(nums, k, true) + minOrMaxSum(nums, k, false);
    }

    private long minOrMaxSum(int[] nums, int k, boolean isMin) {
        long sum = 0L;
        int n = nums.length;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(-1);

        for (int i = 0; i <= n; i++) {
            while (stack.peekFirst() != -1 &&
                (i == n ||
                 (isMin && nums[stack.peekFirst()] >= nums[i]) || 
                 (!isMin && nums[stack.peekFirst()] <= nums[i]))) {
                
                int middle = stack.removeFirst();
                int left = stack.peekFirst() + 1;
                int right = i - 1;
                int minLeft = Math.max(left, middle - k + 1);
                int maxRight = Math.min(middle + k - 1, right);
                long subArrayCount = 0L;

                if (maxRight - minLeft < k) {
                    subArrayCount = (middle - minLeft + 1L) * (maxRight - middle + 1L);
                } else {
                    if (middle - minLeft < maxRight - middle) {
                        
                        for (int l = minLeft; l <= middle; l++) {
                            int maxR = Math.min(right, l + k - 1);
                            subArrayCount += Math.max(maxR - middle + 1, 0);
                        }
                    } else {
                        
                        for (int r = middle; r <= maxRight; r++) {
                            int minL = Math.max(r - k + 1, left);
                            subArrayCount += Math.max(middle - minL + 1, 0);
                        }
                    }
                }

                sum += subArrayCount * nums[middle];
            }
            stack.addFirst(i);
        }

        return sum;
    }
}