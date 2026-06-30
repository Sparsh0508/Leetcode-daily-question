class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String ,List<String>> hm = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);

            if(!hm.containsKey(str)){
                hm.put(str,new ArrayList<>());
            }
            hm.get(str).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}