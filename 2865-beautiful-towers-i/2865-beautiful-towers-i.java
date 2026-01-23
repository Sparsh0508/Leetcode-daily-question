class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long[] left = new long[n];
        long[] right = new long[n];

        Stack<Integer> st = new Stack<>();

        // LEFT PASS
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = (long) heights[i] * (i + 1);
            } else {
                int j = st.peek();
                left[i] = left[j] + (long) heights[i] * (i - j);
            }

            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = (long) heights[i] * (n - i);
            } else {
                int j = st.peek();
                right[i] = right[j] + (long) heights[i] * (j - i);
            }

            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i] - heights[i]);
        }

        return ans;
    }
}
