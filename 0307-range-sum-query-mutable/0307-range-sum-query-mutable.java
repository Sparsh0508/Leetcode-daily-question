class NumArray {
    public int[] tree;
    public int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4*n];
        build(nums,0,0,n-1);    
    }
    
    public void build(int[] nums,int idx,int st,int ed){
        if(st == ed){
            tree[idx] = nums[st];
            return;
        }
        int mid = st + (ed-st)/2;
        int left = 2*idx + 1;
        int right = 2*idx + 2;

        build(nums,left,st,mid);
        build(nums,right,mid+1,ed);

        tree[idx] = tree[left] + tree[right];
    }
    public void update(int index, int val) {
        updateIdx(0,0,n-1,index,val);
    }
    public void updateIdx(int node,int st,int ed,int idx,int val){
        if(st == ed){
            tree[node] = val;
            return;
        }
        int mid = st + (ed-st)/2;
        if(idx <= mid){
            updateIdx(2*node + 1,st,mid,idx,val);
        }else{
            updateIdx(2*node + 2,mid+1,ed,idx,val);
        }
        tree[node] = tree[2*node + 1] + tree[2*node + 2];
    }
    
    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }
    public int query(int node,int st,int ed,int l,int r){
        if(r < st || l> ed){
            return 0;
        }
        if(l <= st && r>= ed){
            return tree[node];
        }
        int mid = st + (ed-st)/2;
        int leftSum = query(2*node + 1,st,mid,l,r);
        int rightSum = query(2*node + 2,mid+1,ed,l,r);
        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */