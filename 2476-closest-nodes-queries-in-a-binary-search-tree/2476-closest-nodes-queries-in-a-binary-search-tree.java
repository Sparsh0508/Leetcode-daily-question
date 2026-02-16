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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        help(root,al2);
        System.out.println(al2);
        for(int i = 0;i<queries.size();i++){
            int floor = findFloor(al2, queries.get(i));
            int ceil = findCeil(al2, queries.get(i));
            al.add(Arrays.asList(floor,ceil));
        }
        return al;
    }
    public static void help(TreeNode root,ArrayList<Integer> al){
        if(root == null){
            return;
        }
        help(root.left,al);
        al.add(root.val);
        help(root.right,al);
    }
    public int findFloor(List<Integer> arr, int target) {
        int l = 0;
        int r = arr.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) <= target) {
                ans = arr.get(mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    public int findCeil(List<Integer> arr, int target) {
        int l = 0;
        int r = arr.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) >= target) {
                ans = arr.get(mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
