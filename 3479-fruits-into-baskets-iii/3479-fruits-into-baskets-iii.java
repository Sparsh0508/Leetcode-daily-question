class Solution {
    int[] st;
    int[] fruits;
    int[] baskets;
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        this.fruits = fruits;
        this.baskets = baskets;
        int n = baskets.length;
        st = new int[4*n];
        Arrays.fill(st,-1);
        build(0,0,n-1);
        int unplaced = 0;
        for(int i = 0;i<fruits.length;i++){
            if(querySt(0,0,n-1,fruits[i]) == false){
                unplaced++;
            }
        }
        return unplaced;
    }
    public boolean querySt(int node,int l,int r,int fruit){
        if(st[node] < fruit){
            return false;
        }
        if(l == r){
            st[node] = -1;
            return true;
        }
        int mid = l +(r-l)/2;
        boolean placed = false;
        if(st[2*node+1] >= fruit){
            placed = querySt(2*node+1,l,mid,fruit);
        }else{
            placed = querySt(2*node+2,mid+1,r,fruit);
        }
        st[node] = Math.max(st[2*node+1],st[2*node+2]);

        return placed;

    }
    public void build(int node,int l,int r){
        if(l == r){
            st[node] = baskets[l];
            return;
        }
        int mid = l+ (r-l)/2;
        build(2*node+1,l,mid);
        build(2*node+2,mid+1,r);
        st[node] = Math.max(st[2*node+1],st[2*node+2]);
    }
}