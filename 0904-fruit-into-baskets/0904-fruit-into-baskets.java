class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int max = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<fruits.length;i++){
            hm.put(fruits[i],hm.getOrDefault(fruits[i],0) + 1);
            while(hm.size() > 2){
                hm.put(fruits[left] , hm.get(fruits[left])-1);
                if(hm.get(fruits[left]) ==0){
                    hm.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max,i-left +1);
        }
        return max;        
    }
}