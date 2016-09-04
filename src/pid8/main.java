package pid8;

/**
 * 8. String to Integer (atoi) Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		String[] testTable = {
//				"+ 1",
//				" 123+-",			
//				" /",
//				"2 ",
//				" 3 ",
//				" 4/5",
//				"6f7",
//				"8e9",
//				"/*8E-9",	//0
//				"/2",
//				".3",
//				"11876562876n",
//				"2147483648",
//				"+1",
//				"-1",
//				"+ 1",
				"+",
				"-2147483647",
				"-2147483648",
				"-2147483649",
		};
		for (String ito : testTable)
			test(ito);
	}

	private static void test(String ito) {
		System.out.println("----------------");
		System.out.print("before='"+ito+"'	");
		
		Solution solution=new Solution();
		int rtn=solution.myAtoi(ito);

		System.out.println("after=	"+rtn);
		System.out.println();

		
	}

}
