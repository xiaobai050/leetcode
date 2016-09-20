package pid;

/**
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int[] testTable = { 
				0, 
			};
		for (int ito : testTable) {
			test(ito);
		}
	}

	private static void test(int ito) {
		System.out.println(ito);

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		solution.method();
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println("ºÄÊ±£º" + (end - begin) + "ms");
		System.out.println("--------------");
	}
}
