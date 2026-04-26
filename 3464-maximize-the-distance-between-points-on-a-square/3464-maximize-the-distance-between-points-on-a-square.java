class Solution {
    private boolean feasible(long[] p, long perimeter, int[] start, int[] len, int k, int dist) {
        for (int j = 0, i = 0; i < p.length; i++) {
            start[i] = i;
            len[i] = 1;
            for (; j < i && p[i] - p[j] >= dist; j++) {
                if (len[j] + 1 >= len[i] && p[i] - p[start[j]] <= perimeter - dist) {
                    len[i] = len[j] + 1;
                    start[i] = start[j];
                    if (len[i] >= k) return true;
                }
            }
        }
        return false;
    }
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long perimeter = side * 4L;
        long[] p = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (x == 0)
                p[i] = y;
            else if (y == side)
                p[i] = side + x;
            else if (x == side)
                p[i] = side * 3L - y;
            else
                p[i] = perimeter - x;
        }
        Arrays.sort(p);
        int[] start = new int[n], len = new int[n];
        int l = 1, r = (int) (perimeter / k);
        while (l < r) {
            int m = l + ((r - l + 1) >> 1);
            if (feasible(p, perimeter, start, len, k, m))
                l = m;
            else
                r = m - 1;
        }
        return l;
    }
}