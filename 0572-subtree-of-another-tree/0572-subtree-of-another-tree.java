/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if (help(root, subRoot)){
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public static boolean help(TreeNode root,TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.val != subRoot.val ){
            return false;
        }
        return help(root.left,subRoot.left) && help(root.right,subRoot.right);
    }
    
}