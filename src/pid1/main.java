package pid1;

public class main {
	public static void main(String[] args) {
		Solution solution=new Solution();
		int numbers[]={3,2,4,4,4};
		int target=6;
		int[]m=solution.twoSum(numbers, target);
		System.out.println(m[0]);
		System.out.println(m[1]);
		
		
	}
}
