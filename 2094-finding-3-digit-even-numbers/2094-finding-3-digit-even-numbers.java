class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> hs = new HashSet<>();
        boolean[] used = new boolean[digits.length];
        help(hs,digits,used,0,0); 
        int[] arr = new int[hs.size()];
        int idx = 0;
        for (int num : hs) arr[idx++] = num;
        Arrays.sort(arr);
        return arr;  
    }
    public static void help(HashSet<Integer> hs,int[] digits,boolean[] used,int curr,int depth){
        if(depth == 3){
            if(curr >= 100 && curr %2 ==0){
                hs.add(curr);
            }
            return;
        }
        for(int i = 0;i<digits.length;i++){
            if(!used[i]){
                if(depth == 0 && digits[i] == 0){
                    continue;
                }
                used[i] = true;

                int newNum = curr * 10 + digits[i];

                help(hs,digits,used,newNum,depth+1);
                used[i] = false;
            }
        }
    }
}