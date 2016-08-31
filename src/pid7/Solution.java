package pid7;

public class Solution {

public static void main(String[] args) {
	
	int[]test_table={0,-1,1,1234567899,100,-1100,-101010,2147483647,2143847412};
	
	System.out.println("x"+"		"+"return ");
	
	for(int i:test_table)
		test(i);
	}	

public static void test(int test_temp){
	
	int rtn=reverse(test_temp);
	System.out.println(test_temp+"	"+rtn);
	}

public static int reverse(int x) {	 
		
	String temp1="";
	if(x<0)
	{
		temp1+='-';
		x=-x;	
	}
	String temp=Integer.toString(x);
	int l=temp.length();
	
	for(int i=0;i<l;i++)
		temp1+=temp.charAt(l-i-1);
	
	int rtn=0;
	
	try{
		rtn=Integer.parseInt(temp1);
	}catch(Exception e){
		return 0;
	};	
    return rtn;
    }
}
