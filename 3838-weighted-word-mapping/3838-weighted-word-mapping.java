class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();
        for(String word : words){
            int weigh = 0;
            for(char ch : word.toCharArray()){
                weigh += weights[ch-'a'];
            }
            weigh = weigh % 26;
            str.append((char)('z'-weigh));
        }
        return str.toString();
    }
}