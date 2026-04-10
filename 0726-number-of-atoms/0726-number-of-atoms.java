class Solution {
    public String countOfAtoms(String form) {
        Stack<HashMap<String,Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        int i = 0;
        int n = form.length();
        while(i<n){
            char ch = form.charAt(i);
            if(ch == '('){
                st.push(new HashMap<>());
                i++;
            }else if(ch == ')'){
                i++;
                int start = i;
                while(i<n && Character.isDigit(form.charAt(i))) i++;
                int mult = start < i ? Integer.parseInt(form.substring(start,i)) : 1;

                HashMap<String,Integer> top = st.pop();
                HashMap<String,Integer> curr = st.peek();

                for(String key: top.keySet()){
                    curr.put(key,curr.getOrDefault(key,0) + top.get(key) * mult);
                }
            }else{
                int start = i;
                i++;
                while(i<n && Character.isLowerCase(form.charAt(i))) i++;
                String ele = form.substring(start,i);
                start = i;
                while(i<n && Character.isDigit(form.charAt(i))) i++;
                int count = start < i ? Integer.parseInt(form.substring(start, i)) : 1;
                HashMap<String,Integer> curr = st.peek();
                curr.put(ele,curr.getOrDefault(ele,0)+count); 
            }
        }
        HashMap<String,Integer> res = st.pop();
        TreeMap<String,Integer> sorted = new TreeMap<>(res);
        StringBuilder sb = new StringBuilder();
        for(String key : sorted.keySet()){
            sb.append(key);
            int count = sorted.get(key);
            if(count > 1){
                sb.append(count);
            }
        }
        return sb.toString();
    }
}