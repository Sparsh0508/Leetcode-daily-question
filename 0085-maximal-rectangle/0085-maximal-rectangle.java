class Solution {
    public int maximalRectangle(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        int[] edge = Arrays.copyOf(heights, heights.length + 1);
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for (int i = 0; i < edge.length; i++) {
            while (!st.isEmpty() && edge[st.peek()] > edge[i]) {
                int h = edge[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                max = Math.max(max, h * width);
            }
            st.push(i);
        }
        return max;
    }
}
