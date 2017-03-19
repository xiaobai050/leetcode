package pid108;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public void display() {
		System.out.print(" " + val);
		if (this.left != null)
			this.left.display();
		if (this.right != null)
			this.right.display();
	}
}
