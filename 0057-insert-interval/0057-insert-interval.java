class Solution {
    public int[][] insert(int[][] arr, int[] newInterval) {
        int i = 0;
        ArrayList<int[]> al = new ArrayList<>();
        while(i<arr.length){
            if(arr[i][1] < newInterval[0]){
                al.add(arr[i]);
            }else if(arr[i][0] > newInterval[1]){
                break;
            }
            else{
                newInterval[0] = Math.min(arr[i][0],newInterval[0]);
                newInterval[1] = Math.max(arr[i][1],newInterval[1]);
            }
            i++;
        }
        al.add(newInterval);
        while(i<arr.length){
            al.add(arr[i]);
            i++;
        }
        return al.toArray(new int[al.size()][]);
    }


}