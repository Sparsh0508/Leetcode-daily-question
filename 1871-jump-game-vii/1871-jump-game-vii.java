class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] visit = new boolean[s.length()];
        visit[0] = true;

        int farthest = 0;
        for(int i = 0;i<s.length();i++){
            if(!visit[i]) continue;
            int st = Math.max(i+minJump,farthest);
            int ed = Math.min(i+maxJump,s.length()-1);
            for(int j = st;j<=ed;j++){
                if(s.charAt(j) == '0'){
                    visit[j] = true;
                }
            }
            farthest = ed+1;
            if(visit[s.length()-1]) return true;
        }       
        return false;
    }
}