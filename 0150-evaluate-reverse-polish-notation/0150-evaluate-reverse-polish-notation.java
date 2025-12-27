class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String i : tokens){
            if(i.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(a+b);
            }
            else if(i.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            }else if(i.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(a*b);
            }else if(i.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }else{
                st.push(Integer.parseInt(i));
            }
        }
        return st.peek();
    }
}