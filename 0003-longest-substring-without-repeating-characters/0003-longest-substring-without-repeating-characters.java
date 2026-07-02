class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        HashSet<Character> hs = new HashSet<>();
        for(int right = 0;right<s.length();right++){
            while(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;   
            }
            hs.add(s.charAt(right));
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}