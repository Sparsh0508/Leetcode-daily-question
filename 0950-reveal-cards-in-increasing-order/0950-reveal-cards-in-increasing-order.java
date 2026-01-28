class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<deck.length;i++){
            q.add(i);
        }
        for(int num :deck){
            int idx =q.poll();
            res[idx] =num;

            if(!q.isEmpty()){
                q.add(q.remove());
            }
        }
        return res;

    }
}