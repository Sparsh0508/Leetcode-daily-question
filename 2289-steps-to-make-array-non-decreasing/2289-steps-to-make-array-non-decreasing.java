class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st = new Stack<>();
        int ans = 0;
        for(int i = nums.length-1;i>=0;i--){
            int c = 0;
            while(!st.isEmpty() && nums[i] > st.peek()[0]){
                c = Math.max(c+1,st.peek()[1]);
                st.pop();
            }
            ans = Math.max(ans,c);
            st.push(new int[]{nums[i],c});
        }
        return ans;
    }
}