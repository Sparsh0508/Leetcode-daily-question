class Solution {
    public String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        
        for (int i = 0; i < n; i += k) {
            int sum = 0;
            for (int j = i; j < Math.min(i + k, n); j++) {
                sum += (s.charAt(j) - 'a');
            }
            sum %= 26;
            result.append((char) ('a' + sum));
        }
        
        return result.toString();
    }
}
