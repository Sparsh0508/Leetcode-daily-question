class ProductOfNumbers {
    ArrayList<Integer> al;
    public ProductOfNumbers() {
        al = new ArrayList<>();
        al.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            al = new ArrayList<>();
            al.add(1);
        }else{
            al.add(al.get(al.size()-1) * num);
        }
    }
    
    public int getProduct(int k) {
        if(k > al.size()-1){
            return 0;
        }else{
            return al.get(al.size()-1)/ al.get(al.size()-k-1);
        }

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */