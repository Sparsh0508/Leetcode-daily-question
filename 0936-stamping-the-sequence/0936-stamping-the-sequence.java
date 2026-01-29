class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        ArrayList<Integer> al = new ArrayList<>();
        boolean[] vis = new boolean[t.length];
        int stars = 0;

        while(stars < t.length){
            boolean doneReplace = false;
            for(int i = 0;i<=t.length-s.length;i++){
                if(!vis[i] && canReplace(t,s,i)){
                    stars = doReplace(t,i,s.length,stars);
                    doneReplace = true;
                    vis[i] = true;
                    al.add(i);
                    if(stars == t.length){
                        break;
                    }
                }
            }
            if(!doneReplace){
                return new int[0];
            }
        }
        int[] res = new int[al.size()];
        for(int i = 0;i<al.size();i++){
            res[i] = al.get(al.size() - i -1);
        }
        return res;
    }
    public boolean canReplace(char[] t, char[] s,int idx){
        for(int i = 0;i<s.length;i++){
            if(t[i+idx] != '?' && t[i+idx] != s[i]){
                return false;
            }
        }
        return true;
    }
    public int doReplace(char[] t,int idx,int len,int c){
        for(int i = 0;i<len;i++){
            if(t[i+idx] != '?'){
                t[i + idx] = '?';
                c++;
            }
        }
        return c;
    }
}