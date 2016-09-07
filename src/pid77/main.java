package pid77;

import java.util.List;

public class main {
	public static void main(String[] args) {
		int n = 4;
		int k = 2;

		test(n,k);
	}
	private static void test(int n, int k) {
		Solution solution = new Solution();
		List<List<Integer>>rtn;
		rtn=solution.combine(n, k);
//		System.out.println(rtn);
	}
}
