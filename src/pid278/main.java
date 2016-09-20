package pid278;

public class main {
	public static void main(String[] args) {
		
		
		int [][]testTable={
				{5,3},
				{1,1},
				{123123,12312},
		};
		for(int[]ito :testTable){
			test(ito);
		}
		
	}

	private static void test(int[] ito) {
		
		VersionControl.bad=ito[1];
		int n=ito[0];
		Solution solution= new Solution();
		int rtn=solution.firstBadVersion(n);
		System.out.println(rtn);
	}
}
