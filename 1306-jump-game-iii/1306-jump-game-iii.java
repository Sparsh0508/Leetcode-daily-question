class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return help(arr, start, visited);
    }

    public static boolean help(int[] arr, int idx, boolean[] visited) {
        if (idx < 0 || idx >= arr.length || visited[idx]) {
            return false;
        }
        if (arr[idx] == 0) {
            return true;
        }
        visited[idx] = true;
        return help(arr, idx - arr[idx], visited) || help(arr, idx + arr[idx], visited);
    }
}