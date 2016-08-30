package test;

public class charTest {
	public static void main(String[] args) {
		
		char[] data = {'s', 'g', 'k'}; 
		  char []ch = new char[10];
		  String s = "Hello";
		  ch = s.toCharArray();
		  System.out.println(ch); 

		data[2]='o';
		String str = new String(data);
		System.out.println(str);
	}
}
