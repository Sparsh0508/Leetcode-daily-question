class Solution {
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        
        StringBuilder flipped = new StringBuilder();
        
        for(char c : binary.toCharArray()){
            if(c == '0'){
                flipped.append('1');
            }else{
                flipped.append('0');
            }
        }
        
        return Integer.parseInt(flipped.toString(), 2);
    }
}