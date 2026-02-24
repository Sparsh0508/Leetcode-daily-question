class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return help(root,0);
    }
    int help(TreeNode root, int curr){
        if(root == null){
            return 0;
        }
        curr = curr *2 + root.val;
         
        if(root.left == null && root.right == null){
            return curr;
        }
        return help(root.left,curr)+help(root.right,curr);
    }
}