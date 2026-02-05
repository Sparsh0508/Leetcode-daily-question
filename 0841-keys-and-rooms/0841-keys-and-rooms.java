class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[rooms.size()];
        bfs(rooms,visit);

        for(boolean i : visit){
            if(!i){
                return false;
            }
        }
        return true;
    }
    public static void bfs(List<List<Integer>> rooms,boolean[] visit){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visit[0] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i : rooms.get(curr)){
                if(!visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}