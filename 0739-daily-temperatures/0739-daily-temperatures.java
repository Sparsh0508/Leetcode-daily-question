class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int res[] = new int[nums.length];
        // for(int i = 0;i<nums.length-1;i++){
        //     for(int j = i+1;j<nums.length;j++){
        //         if(nums[i] < nums[j]){
        //             res[i] = j-i;
        //             break;
        //         }
        //     }
        // }
        // return res;

        Stack<Integer> st = new Stack();
        for(int i = 0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                int prev = st.pop();
                res[prev] = i - prev;
            }
            st.push(i);
        }
        return res;
    }
} 