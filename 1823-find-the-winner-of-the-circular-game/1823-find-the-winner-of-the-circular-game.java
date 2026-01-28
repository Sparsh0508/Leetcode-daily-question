class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i<= n;i++){
            q.add(i);
        }
        while(q.size() != 1){
            int x = 1;
            while(x < k){
                q.add(q.remove());
                x++;
            }
            q.remove();
            
        }
        return q.peek();
    }
    
}