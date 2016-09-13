package pid108;

/**
 * Convert Sorted Array to Binary Search Tree Given an array where elements are
 * sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int[][] numsTable = {
				{},
				{1},
				{1,2},
				{1,2,3},
				{1,2,3,4},
				{1,2,3,4,5},
				{1,2,3,4,5,6,7,8,9},
		};
		for (int[] ito : numsTable) {
			test(ito);
		}
	}

	private static void test(int[] nums) {
		Solution solution = new Solution();
		long begin = System.currentTimeMillis();

		TreeNode rtn = solution.sortedArrayToBST(nums);

		long end = System.currentTimeMillis();
		System.out.println("ºÄÊ±" + (end - begin) + "ms");
		System.out.println("-----------------");
	}
}
