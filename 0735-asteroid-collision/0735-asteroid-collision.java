class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int num : nums){
            while(!st.isEmpty() && num < 0 && st.peek() > 0){
                int sum = num + st.peek();
                if(sum < 0){
                    st.pop();
                }else if(sum > 0){
                    num = 0;
                }else{
                    num = 0;
                    st.pop();
                }
            }
            if(num != 0){
                st.push(num);
            }
        }
        int[] res = new int[st.size()];
        int i = st.size()-1;
        while(!st.isEmpty()){
            res[i] = st.pop();
            i--;
        }
        return res;
    }
}