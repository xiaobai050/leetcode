package pid77;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<List<Integer>> rtn = new ArrayList<List<Integer>>();
	List<Integer> temp = new ArrayList<Integer>();

	public List<List<Integer>> combine(int n, int k) {
		int totle=k;
		int end=n;
		for (int i = 0; i < k; i++)
			temp.add(0);
		solve(0, totle, 1, end);
		return rtn;
	}

	public void solve(int count, int totle, int start, int end) {
		if (count == totle) {
			List<Integer> tempAdd = new ArrayList<Integer>(temp); // ��Ҫ�½�һ��List����tset�����w֮ǰ�ѽ�add��List
			rtn.add(tempAdd);
			return;
		}
		for (int i = start; i <= end; i++) {
			temp.set(count, i);
			solve(count + 1, totle, i + 1, end);
		}
	}
}