package pid96;

public class Solution {
	public int numTrees(int n) {

		if (n <= 1)
			return 1;
		if (n == 2)
			return 2;

		int[] table = new int[n + 1];

		table[0] = 1;
		table[1] = 1;
		table[2] = 2;

		for (int i = 2; i < n; i++)
			for (int j = 0; j <= i; j++)
				table[i + 1] += table[i - j] * table[j];

		return table[n];
	}
}