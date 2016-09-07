package pid77;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<List<Integer>> rtn = new ArrayList<List<Integer>>();
	List<Integer> temp = new ArrayList<Integer>();

	public List<List<Integer>> combine(int n, int k) {
		for (int i = 0; i < k; i++)
			temp.add(0);
		solve(0, k, n, 1);
		return rtn;
	}

	public void solve(int index, int k, int n, int start) {
		if (index == k) {
			List<Integer> tempAdd = new ArrayList<Integer>(temp); // 需要新建一個List，否則set會覆蓋之前已經add的List

			rtn.add(tempAdd);
			// System.out.println(rtn);
			return;
		}
		for (int i = start; i <= n; i++) {
			temp.set(index, i);
			// System.out.println("i="+i+" index="+index);
			solve(index + 1, k, n, i + 1);
		}
	}
}