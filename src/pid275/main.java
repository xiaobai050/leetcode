package pid275;

import java.util.Arrays;

import pid275.Solution;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 * 
 * @author Administrator
 *
 */
public class main {
	public static void main(String[] args) {
		int[][] citationsTable = { 
				{ 0 }, 
				{ 1 }, 
				{ 2 }, 
				{ 0, 1 },
				{ 0, 1, 3, 3, 3 }, 
				{ 5, 5, 5 }, { 2 },
				{ 1, 2, 3, 4, 5, 7, 8, 9 }, 
				{ 3, 4, 5, 6, 7 },
				{ 3, 0, 6, 1, 5 },
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 },
				};
		for (int[] ito : citationsTable) {
			test(ito);
		}
	}

	private static void test(int[] citations) {
		Solution solution = new Solution();
		sort(citations);
		int rtn = solution.hIndex(citations);
		System.out.println(rtn);
		System.out.println("---------");
	}

	private static void sort(int[] citations) {
		Arrays.sort(citations);
	}

}
