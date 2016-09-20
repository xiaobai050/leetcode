package pid96;

/**
 * Unique Binary Search Trees 
 * 
 * Given n, how many structurally unique BST's
 * (binary search trees) that store values 1...n?
 * 
 * For example, Given n = 3, there are a total of 5 unique BST's.
 * 
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 *  
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int[] testTable = { 0, 1, 2, 3, 4, 5, 6, 10, };
		for (int ito : testTable) {
			test(ito);
		}
	}

	private static void test(int ito) {
		Solution solution = new Solution();
		int rtn;
		long begin = System.currentTimeMillis();
		rtn = solution.numTrees(ito);
		long end = System.currentTimeMillis();
		System.out.println(ito + ":	rtn=" + rtn);
		System.out.println();
		System.out.println("ºÄÊ±£º" + (end - begin) + "ms");
		System.out.println("-------------------");
	}
}
