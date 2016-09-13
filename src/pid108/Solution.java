package pid108;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	int count = 0;
	int[] nums;
	int deepMax;
	TreeNode head;
	int len;
	int endCount = 0;
	int endMax;

	public TreeNode sortedArrayToBST(int[] nums) {
		len = nums.length;
		if (len == 0)
			return null;
		deepMax = (int) (Math.log(len + 1) / Math.log(2));
		endMax = len - (int) Math.pow(2, deepMax) + 1;

		this.nums = nums;
		TreeNode head = new TreeNode(nums[0]);
		this.head = head;

		insert(head, 0);

		// head.display();
		// System.out.println();

		return head;

	}

	private void insert(TreeNode thisNode, int deep) {
		// System.out.println("deep="+deep);
		if (deep == deepMax) { // 超过了
			if (thisNode == null)
				return;
		} else if (deep == deepMax - 1) { // 最后一行
			if (endCount++ < endMax) {
				if (thisNode.left == null)
					thisNode.left = new TreeNode(0);
			}
			if (endCount++ < endMax) {
				if (thisNode.right == null)
					thisNode.right = new TreeNode(0);
			}
		} else { // 没到最后一行
			thisNode.left = new TreeNode(0);
			thisNode.right = new TreeNode(0);
		}

		if (thisNode.left != null)
			insert(thisNode.left, deep + 1);

		if (count < len)
			thisNode.val = nums[count++];

		if (thisNode.right != null)
			insert(thisNode.right, deep + 1);

	}

}
