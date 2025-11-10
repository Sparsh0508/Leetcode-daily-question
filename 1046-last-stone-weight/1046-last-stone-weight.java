class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int num : stones){
            pq.add(num);
        }   
        while(!pq.isEmpty()){
            if(pq.size() == 1){
                return pq.remove();
            }
            int y = pq.remove();
            int x = pq.remove();
            if(x != y){
                int sub = y-x;
                pq.add(sub);
            }
        }
        return 0;
    }
}