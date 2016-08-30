package pid17;

import java.util.List;

public class main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> rtn = null;
		String digits = "79";
		
		rtn = solution.letterCombinations(digits);
		System.out.println(rtn);
		
		
		rtn = solution.letterCombinations("23");
		System.out.println(rtn);
	}
}
