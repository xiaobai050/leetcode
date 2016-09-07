package test.Recursion;

public class GreatestCommonDivisor {
	public int figure(int a,int b){
		
		
		return solve(a,b);
	}

	private int solve(int a, int b) {
		if(a<b){
			int t=a;
			a=b;
			b=t;
		}
		if(a%b==0){			
			return b;
		}
		return solve(a-b,b);		
	}
	
}
