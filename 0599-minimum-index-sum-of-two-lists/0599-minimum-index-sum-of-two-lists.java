class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int sum = Integer.MAX_VALUE;
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0;i<list1.length;i++){
            for(int j = 0;j<list2.length;j++){
                if(list1[i].equals(list2[j])){
                    if(sum > i+j){
                        al.clear();
                        al.add(list1[i]);
                        sum = i+j;
                    }else if(sum == i+j){
                        al.add(list2[j]);
                    }
                }
            }
        }
        String[] str = new String[al.size()];
        for(int i = 0;i<al.size();i++){
            str[i] = al.get(i);
        }
        return str;
    }
}