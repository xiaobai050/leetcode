package pid109;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
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
