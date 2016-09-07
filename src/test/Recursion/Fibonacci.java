package test.Recursion;

public class Fibonacci {
	int sum=0;
	public int theFirstN(int n){
		
		solve(1,20,1,2);
		return n;
	}
	
	public void solve (int index,int n,int a, int b){
		if(index==n){
			return;
		}
		
		{
			System.out.println(a);
			solve(index+1,n,b,a+b);
		}
	}
}
