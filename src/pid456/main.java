package pid456;

/**
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		
		int[] testTable = { 0, 1, 2, 3, 4 };
		
		for (int ito : testTable) {
			test(ito);
		}
		
	}

	private static void test(int ito) {
		
		System.out.print(">> ");
		System.out.print(ito);
		System.out.println();

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		Object rtn = solution.method();
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println("                              << " + rtn);
		System.out.println("--------------------------------------ºÄÊ±£º" + (end - begin) + "ms");
	
	}
}
