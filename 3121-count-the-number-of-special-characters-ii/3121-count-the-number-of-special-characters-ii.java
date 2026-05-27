class Solution {
    public int numberOfSpecialChars(String word) {        
        int[] lower = new int[26];
        int[] upper = new int[26];

        Arrays.fill(lower, -1);
        Arrays.fill(upper, -1);

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lower[ch - 'a'] = i;
            }
            else {
                int idx = ch - 'A';
                if (upper[idx] == -1) {
                    upper[idx] = i;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] != -1 && upper[i] != -1) {
                if (lower[i] < upper[i]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}