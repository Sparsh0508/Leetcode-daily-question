class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> hs = new HashSet<>();
        q.offer(start);
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0;i<size;i++){
                int val = q.poll();
                if(val == goal){
                    return ans;
                }
                if((val < 0 || val > 1000 || hs.contains(val))){
                    continue;
                }
                if(!hs.contains(val)){
                    hs.add(val);
                }

                for(int num : nums){
                    q.offer(val + num);
                    q.offer(val - num);
                    q.offer(val ^num);
                }
            }
            ans++;
        }
        return -1;
    }
}