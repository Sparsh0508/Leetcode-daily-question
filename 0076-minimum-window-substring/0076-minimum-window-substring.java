class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || s.length() == 0 || t.length() == 0){
            return "";
        }

        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c: t.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        HashMap<Character,Integer> window = new HashMap<>();
        int req = hm.size();
        int formed = 0;

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);

            if(hm.containsKey(ch) && window.get(ch).intValue() == hm.get(ch).intValue()){
                formed++;
            }

            while(left <= right && formed == req){
                if(right-left+1 < minLen){
                    minLen = right-left + 1;
                    minLeft = left;
                }

                char c = s.charAt(left);

                window.put(c,window.get(c) -1);
                if(hm.containsKey(c) && window.get(c).intValue() < hm.get(c).intValue()){
                    formed--;
                }
                left ++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" :s.substring(minLeft,minLeft+minLen);
    }
}