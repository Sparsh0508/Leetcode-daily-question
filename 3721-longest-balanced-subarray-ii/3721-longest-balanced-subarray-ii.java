class Solution {
    int[] segMin,segMax, lazy;
    int n;

    public void propogate(int node,int l,int r){
        if(lazy[node] != 0){
            segMin[node] += lazy[node];
            segMax[node] += lazy[node];

            if(l!=r){
                lazy[2*node+1] += lazy[node];
                lazy[2*node+2] += lazy[node];
            }
            lazy[node] = 0;
        }
    }
    public void updateRange(int start,int end,int node,int l,int r,int val){
        propogate(node,l,r);
        if(l>end || r< start){
            return;
        }
        if(l>= start && r<= end){
            lazy[node] += val;
            propogate(node,l,r);
            return;
        }
        int mid = l + (r-l)/2;
        updateRange(start,end,2*node+1,l,mid,val);
        updateRange(start,end,2*node+2,mid+1,r,val);

        segMin[node] = Math.min(segMin[2*node+1],segMin[2*node+2]);
        segMax[node] = Math.max(segMax[2*node+1],segMax[2*node+2]);
    }
    public int findLeftMostZero(int node,int l,int r){
        propogate(node,l,r);

        if(segMin[node] > 0 || segMax[node] < 0){
            return -1;
        }
        if(l == r){
            return l;
        }

        int mid = l + (r-l)/2;
        int leftRes = findLeftMostZero(2*node+1,l,mid);
        if(leftRes != -1){
            return leftRes;
        }
        return findLeftMostZero(2*node+2,mid+1,r);
    }

    public int longestBalanced(int[] nums) {
        n = nums.length;
        segMin = new int[4*n];
        segMax = new int[4*n];
        lazy = new int[4*n];

        int[] cumSum = new int[n];
        int maxL = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int r = 0;r < n;r++){
            int val = 0;
            if(nums[r] % 2 == 0){
                val = 1;
            }else{
                val = -1;
            }
            int prev = -1;
            if(hm.containsKey(nums[r])){
                prev = hm.get(nums[r]);
            }
            if(prev != -1){
                // for(int l = 0;l<=prev;l++){
                //     cumSum[l] -= val;
                // }

                updateRange(0,prev,0,0,n-1,-val);
            }
            updateRange(0,r,0,0,n-1,val);
            int l = findLeftMostZero(0,0,n-1);
            if(l != -1){
                maxL = Math.max(maxL,r-l+1);
            }
            hm.put (nums[r],r);
        }
        return maxL;
    }
}