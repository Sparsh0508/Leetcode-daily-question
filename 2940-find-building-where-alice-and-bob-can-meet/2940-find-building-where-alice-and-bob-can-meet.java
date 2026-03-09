class Solution {
    int[] st;
    int[] heights;
    public void build(int n,int node,int l,int r){
        if(l == r){
            st[node] = l;
            return;
        }
        int mid = l + (r-l)/2;
        build(n,2*node+1,l,mid);
        build(n,2*node+2,mid+1,r);
        
        int leftIdx = st[2*node+1];
        int rightIdx = st[2*node+2];
        if(heights[leftIdx] >= heights[rightIdx]){
            st[node] = leftIdx;
        }else{
            st[node] = rightIdx;
        }
    }

    public int RMIQ(int n,int a,int b){
        return query(a,b,0,0,n-1);
    }
    public int query(int start,int ed,int node,int l,int r){
        if(l>ed || r<start){
            return -1;
        }
        if(l>=start && r<=ed){
            return st[node];
        }
        int mid = l + (r-l)/2;
        int leftIdx = query(start,ed,2*node+1,l,mid);
        int rightIdx = query(start,ed,2*node+2,mid+1,r);
        if(leftIdx == -1){
             return rightIdx;
        }
        if(rightIdx == -1){
            return leftIdx;
        }
        if(heights[leftIdx] >= heights[rightIdx]){
            return leftIdx;
        }else{
            return rightIdx;
        }
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        this.heights = heights;
        st = new int[4*n];
        build(n,0,0,n-1);

        int[] ans = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            int minIdx = Math.min(queries[i][0],queries[i][1]);
            int maxIdx = Math.max(queries[i][0],queries[i][1]);
            if(minIdx == maxIdx){
                ans[i] = minIdx;
                continue;
            }else if(heights[maxIdx] > heights[minIdx]){
                ans[i] = maxIdx;
                continue;
            }
            int l = maxIdx + 1;
            int r = n-1;
            int res = Integer.MAX_VALUE;

            while(l<=r){
                int mid = l +(r-l)/2;
                int idx = RMIQ(n,l,mid);

                if(heights[idx] > Math.max(heights[minIdx],heights[maxIdx])){
                    res = Math.min(res,idx);
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
            if(res == Integer.MAX_VALUE){
                ans[i] = -1;
            }else{
                ans[i] = res;
            }
            
        }
        return ans;

    }
}