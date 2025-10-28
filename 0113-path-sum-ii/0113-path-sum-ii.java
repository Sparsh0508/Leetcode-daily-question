class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        help(al,l,root,targetSum);
        return al;        
    }
    void help(List<List<Integer>> al ,List<Integer> l,TreeNode root,int sum){
        if(root == null){
            return;
        }
        l.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum){
                al.add(new ArrayList(l));
            }
        }
        help(al,l,root.left,sum-root.val);
        help(al,l,root.right,sum-root.val);
        l.remove(l.size()-1);
    }
}