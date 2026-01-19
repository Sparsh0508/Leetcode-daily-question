class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty()){
                char top = st.peek();
                if((top == 'A' && ch == 'B') || top == 'C' && ch =='D'){
                    st.pop();
                    continue;
                }
            }
            st.push(ch);
        }
        return st.size();
    }
}