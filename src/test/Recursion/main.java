package test.Recursion;

public class main {
	public static void main(String[] args) {
//		testFibonacci(2);
//		testGreatestCommonDivisor(6,18);
		testBinaryTree();
		
	}

	private static void testBinaryTree() {
		BinaryTree binaryTree= new BinaryTree();
		binaryTree.solve(10);
	}

	private static void testGreatestCommonDivisor(int a,int b) {

		GreatestCommonDivisor greatestCommonDivisor=new GreatestCommonDivisor();
		int rtn=greatestCommonDivisor.figure(a,b);
		System.out.println(rtn);
	}

	private static void testFibonacci(int n) {
		Fibonacci fibonacci= new Fibonacci();
		int sum = fibonacci.theFirstN(n);
//		System.out.println("sum="+sum);
	}
	
	
	
}
