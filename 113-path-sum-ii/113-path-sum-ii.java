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
   public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root, targetSum, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void pathSum(TreeNode node, int targetSum, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        
        path.add(node.val);
        sum += node.val;
        
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        }
        
        else {
            pathSum(node.left, targetSum, sum, path, ans);
            pathSum(node.right, targetSum, sum, path, ans);
        }
        
        path.remove(path.size() - 1);
    }
}