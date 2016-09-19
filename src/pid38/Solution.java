package pid38;

public class Solution {

	public String countAndSay(int n) {

		String in = "1";
		return solve(in, n);

	}

	private String solve(String in, int n) {

		if (n <= 1)
			return in;

		int count = 0;
		int lastCount = 0;
		String out = "";

		while (count < in.length()) {

			if (in.charAt(count) != in.charAt(lastCount)) {
				out += (char) (count - lastCount + '0');
				out += in.charAt(lastCount);
				lastCount = count;
			}
			count++;

		}

		out += (char) (count - lastCount + '0');
		out += in.charAt(lastCount);

		out = solve(out, n - 1);

		return out;
	}
}