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
    public TreeNode sortedArrayToBST(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }
    
    public TreeNode divide(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        
        int mid = low + (high - low) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = divide(nums, low, mid - 1);
        root.right = divide(nums, mid + 1, high);
        
        return root;
    }
}