class Solution {
     static public int longestPalindrome(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int n1 = arr1.length;
        int n2 = arr2.length;
        max = 0;

        int[][] dp = new int[n1][n1];
        int[] LCS1 = longestPalindromeSubstring(arr1, dp, n1);

        dp = new int[n2][n2];
        char[] temp = Arrays.copyOf(arr2, n2);

        reverse(temp);
        int[] LCS2 = longestPalindromeSubstring(temp, dp, n2);
        reverse(LCS2);
        
        Integer[][][] dp2 = new Integer[n1][n2][2];
        int ans = solve(0, n2 - 1, 0, arr1, arr2, LCS1, LCS2, dp2);
        return Math.max(ans, max);
    }

    static int max = 0;

    static int solve(int i, int j, int started, char[] arr1, char[] arr2, int[] LCS1, int[] LCS2, Integer[][][] dp) {
        if (i == arr1.length || j < 0) {
            int a = 0;
            if (i < arr1.length) a = LCS1[i];
            if (j >= 0) a = Math.max(a, LCS2[j]);
            return a;
        }
        if (dp[i][j][started] != null) {
            return dp[i][j][started];
        }

        int a = 0, b = 0, c = 0;
        if (started == 0) {
            b = solve(i, j - 1, 0, arr1, arr2, LCS1, LCS2, dp);
            a = solve(i + 1, j, 0, arr1, arr2, LCS1, LCS2, dp);
        }

        if (arr1[i] == arr2[j]) {
            c = 2 + solve(i + 1, j - 1, 1, arr1, arr2, LCS1, LCS2, dp);
        } else {
            c = Math.max(LCS1[i], LCS2[j]);
        }
        return dp[i][j][started] = Math.max(a, Math.max(c, b));
    }

    static int[] longestPalindromeSubstring(char[] arr, int[][] dp, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) dp[i][j] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (dp[i][j] == 1) {
                    dp[i][j] += dp[i + 1][j - 1];
                }
            }
        }

        int[] LCS1 = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i, x = 0; j < n; j++, x++) {
                if (Math.abs(dp[i][j] - dp[i + x][j - x]) == x) {
                    LCS1[i] = Math.max(LCS1[i], x + 1);
                    max = Math.max(max, x + 1);
                }
            }
        }
        return LCS1;
    }

    static void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
            i++;
            j--;
        }
    }

    static void reverse(char[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
            i++;
            j--;
        }
    }
}