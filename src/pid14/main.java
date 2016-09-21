package pid14;

/**
 * Longest Common Prefix Write a function to find the longest common prefix
 * string amongst an array of strings.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		String[][] testTable = { { "" }, { "j" }, { "avcva", "avcbbbb" }, };
		for (String[] ito : testTable) {
			test(ito);
		}
	}

	private static void test(String[] ito) {

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		String rtn = "";
		for (int i = 0; i < 100000; i++)
			rtn = solution.longestCommonPrefix(ito);
		long end = System.currentTimeMillis();
		System.out.println(rtn);
		System.out.println("ºÄÊ±£º" + (end - begin) + "ms");
		System.out.println("--------------");
	}
}
