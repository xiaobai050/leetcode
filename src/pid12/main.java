package pid12;

public class main {
	public static void main(String[] args) {
		int[]numberTable={
			0
		};
		
		for(int ito:numberTable){
			test(ito);
		}
	}

	private static void test(int number) {
		
		Solution solution = new Solution();
		String rtn="";

		long begin=System.currentTimeMillis();
		
		for(number=1;number<4000;number++)rtn=solution.intToRoman(number);

		long end=System.currentTimeMillis();

//		System.out.println(rtn);
		System.out.println("ºÄÊ±"+(end-begin)+"ms");
		System.out.println("---------");
	}
}
