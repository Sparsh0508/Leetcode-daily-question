class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i<= n;i++){
            q.add(i);
        }
        int x = 1;
        while(q.size() != 1){
            if(x<k){
                q.add(q.remove());
                x++;
            }
            else{
                q.remove();
                x = 1;
            }
        }
        return q.peek();
    }
    
}