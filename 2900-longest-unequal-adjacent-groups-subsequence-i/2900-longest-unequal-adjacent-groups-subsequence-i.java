class Solution {
    List<String> al = new ArrayList<>();
    
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        help(words, groups, -1, 0);
        return al;
    }

    public void help(String[] words, int[] groups, int prev, int idx) {
        if (idx == words.length) {
            return;
        }

        if (groups[idx] != prev) {
            al.add(words[idx]);
            help(words, groups, groups[idx], idx + 1);
        } else {
            help(words, groups, prev, idx + 1);
        }
    }
}
