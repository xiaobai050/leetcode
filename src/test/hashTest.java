package test;

public class hashTest {
	public static void main(String[] args) {
		String str="01";
		Integer in=1;
		Character cha='0';
		int hash=0;
		
		for(in=0;in<40;in+=1){
			hash=(in).hashCode();
			if(hash!=in)
				System.out.println(hash);			
		}
		System.out.println("ok");
		
		System.out.println("Ôæ×¯".hashCode()); 
		System.out.println("ÎÞÎý".hashCode()); 
		System.out.println("ÓïÎÄ".hashCode()); 
	}
}
