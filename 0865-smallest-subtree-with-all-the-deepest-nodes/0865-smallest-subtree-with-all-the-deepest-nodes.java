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
    TreeNode ans;
    int max;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ans = null;
        max = -1;
        dfs(root,0);
        return ans;
    }
    public int dfs(TreeNode root,int level){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left,level+1);
        int right = dfs(root.right,level+1);

        if(left == right && (left+level) >= max){
            ans = root;
            max = left+level;
        }

        return 1 + Math.max(left,right);
    }
}