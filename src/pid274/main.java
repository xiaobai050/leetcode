package pid274;

/**
 * H-Index
 * Given an array of citations (each citation is a non-negative integer) of a
 * researcher, write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively. Since the researcher has 3 papers with at least 3 citations
 * each and the remaining two with no more than 3 citations each, his h-index is
 * 3.
 * 
 * @author Administrator
 *
 */
public class main {
	public static void main(String[] args) {
		int[][] citationsTable={
				{},
				{0},
				{1},
				{2},
				{1,2,3,4,5,7,8,9},
				{3, 0, 6, 1, 5},
				{1,2,3,4,5,6},				
		};
		for (int[] ito : citationsTable) {
			test(ito);
		}
	}

	private static void test(int[] citations) {
		Solution solution = new Solution();
		int rtn = solution.hIndex(citations);
		System.out.println(rtn);
		System.out.println("---------");
	}
}
