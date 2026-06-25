class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int num : stones){
            al.add(num);
        }
        while(al.size() > 1){
            int m1 = Collections.max(al);
            al.remove(Integer.valueOf(m1));
            int m2 = Collections.max(al);
            al.remove(Integer.valueOf(m2));
            if(m1 != m2){
                al.add(m1-m2);
            }
        }
        if(al.size() == 0){
            return 0;
        }
        return al.get(0);
    }
}