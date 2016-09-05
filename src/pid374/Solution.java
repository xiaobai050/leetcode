package pid374;

public class Solution {

	public static int guessNumber(int n) {
		int guessPickedNum = 1;
		int max = n;
		int min = 1;
		int rtn = 1;
		while (max>min+1) {
			// 大了，更新最小值
			guessPickedNum = max/2 + min / 2;
			if (guess(guessPickedNum) == 1) {
				max = guessPickedNum;
				 System.out.println("higher,guessPickedNum="+guessPickedNum+"max="+max+" min="+min);
			}
			// 小了，更新最大值
			if (guess(guessPickedNum) == -1) {
				min = guessPickedNum;
				 System.out.println("lower,guessPickedNum="+guessPickedNum+"max="+max+" min="+min);
			}
			// 相等，break
			if (guess(guessPickedNum) == 0) {
				rtn = guessPickedNum;
				break;
			}
		}
		if (guess(min) == 0) {
			rtn = min;
		}
		if (guess(max) == 0) {
			rtn = max;
		}
		return rtn;

	}

	public static void main(String[] args) {
		//for (int i = 1; i < 12; i++)
			
    		
    	long start = System.currentTimeMillis();
		test(10,6);
    	long end = System.currentTimeMillis();
    	
    	
    	System.out.println("time="+(end-start)+"ms");
    	
    	
    	
	}

	public static int test(int n, int guessPickedNum) {

		findNumber.setPickedNumber(guessPickedNum);
		guessPickedNum = guessNumber(n);
		System.out.println("n=" + n + "  guess=" + guessPickedNum);
		return guessPickedNum;
	}

	public static int guess(int num) {
		int rtn = 0;
		/**********************/
		int pickedNum = findNumber.getPickedNumber();

		/**********************/
		if (num > pickedNum)
			rtn = 1;
		else if (num < pickedNum)
			rtn = -1;
		return rtn;
	}

}
