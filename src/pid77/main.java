package pid77;

import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * @author Administrator
 *
 */
public class main {
	public static void main(String[] args) {
		int n = 4;
		int k = 2;

		test(n, k);
//		test(6, 3);
//		test(1, 1);
	}

	private static void test(int n, int k) {
		Solution solution = new Solution();
		List<List<Integer>> rtn;
		rtn = solution.combine(n, k);
		System.out.println(rtn);
	}
}
