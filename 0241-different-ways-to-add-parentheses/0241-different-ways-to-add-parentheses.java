class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        return help(exp);
    }
    public static List<Integer> help(String s){
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                List<Integer> left = help(s.substring(0,i));
                List<Integer> right = help(s.substring(i+1));

                for(int l : left){
                    for(int j : right){
                        if(ch == '+') res.add(l+j);
                        else if(ch == '-') res.add(l-j);
                        else if(ch == '*') res.add(l*j);

                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.parseInt(s));
        }
        return res;
    }
}