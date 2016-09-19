package pid38;

/**
 * Count and Say
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int[] nTable = { -1, 0, 1, 2, 3, 4, 5, 6, 11, 33 };
		for (int ito : nTable) {
			test(ito);
		}
	}

	private static void test(int n) {
		Solution solution = new Solution();
		String rtn;
		long begin = System.currentTimeMillis();
		rtn = solution.countAndSay(n);
		long end = System.currentTimeMillis();

		System.out.println(rtn);
		System.out.println();
		System.out.println("ºÄÊ±:" + (end - begin));
		System.out.println("------");
	}

}
