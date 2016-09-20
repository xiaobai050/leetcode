package pid13;
/**
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		String[]testTable={
				"MDLXX","","MMMDLXXXVI"
		};
		for(String ito:testTable){
			test(ito);
		}
	}

	private static void test(String s) {
		
		System.out.println(s);
		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		int rtn = solution.romanToInt(s);
		long end = System.currentTimeMillis();
		System.out.println(rtn);
		System.out.println();
		System.out.println("ºÄÊ±£º"+(end-begin)+"ms"); 
		System.out.println("-----------");
	}
}
