package pid198;

/**
 * House Robber
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int [][] numsTable={
						{},
						{1},
						{2,1},
						{1,5,2},
				{1,2,3,4,5,6,7,8,9},

		};
		for(int [] ito:numsTable){
			test(ito);			
		}
	}

	private static void test(int[] nums) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int rtn = solution.rob(nums);
		System.out.println(rtn);
	}
}
