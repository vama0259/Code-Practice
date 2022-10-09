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
    ArrayList<Integer> ans;
	public boolean findTarget(TreeNode root, int k) {
		ans = new ArrayList<>();
		fillInorder(root);

		int l = 0, r = ans.size() - 1;

		while(l < r){
			if(ans.get(l) + ans.get(r) == k){
				return true;
			}
			else if(ans.get(l) + ans.get(r) > k){
				r--;
			}
			else{
				l++;
			}
		}

		return false;
	}

	private void fillInorder(TreeNode node){
		if(node == null){
			return;
		}

		fillInorder(node.left);
		ans.add(node.val);
		fillInorder(node.right);
	}
}