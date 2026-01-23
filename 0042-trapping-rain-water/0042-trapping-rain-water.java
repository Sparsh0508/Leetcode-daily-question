class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int mid = st.pop(); 

                if (st.isEmpty()) break;

                int left = st.peek();
                int width = i - left - 1;
                int boundedHeight = Math.min(height[left], height[i]) - height[mid];

                water += width * boundedHeight;
            }
            st.push(i);
        }
        return water;
    }
}
