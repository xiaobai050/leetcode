package pid6;

public class Solution {
	
	
	public static void main(String[] args) {
		Solution m=new Solution();
		String rtn=	m.convert("PAYPALISHIRING", 3);
	    System.out.println("my return:	"+rtn );
	    System.out.println("expect:		PAHNAPLSIIGYIR");

	}

	
	
	public String convert(String s, int numRows) {
		
		int lth_of_v=numRows*2-2; 
	    
		if(lth_of_v<2)return s;
		
		int number_of_v=s.length()/lth_of_v;
	    int number_of_left=s.length()%lth_of_v;
	    int i=2;
    	char result;
	    for(i=0;i<lth_of_v-number_of_left;i++)
	    	s+='8';
	    String res ="";
	    String []rtn= new String[number_of_v+1];
	  
	    for(i=0;i<=number_of_v;i++){
	    	rtn[i]=new String(s.substring(i*lth_of_v,(i+1)*lth_of_v));
	    	
	    }
	    
	    
	    for(i=0;i<=number_of_v;i++){
	    	result=rtn[i].charAt(0);
	    	if(result!='8')res+=result;
	    }
	    int j;
	    for(j=1;j<numRows-1;j++)
	    for(i=0;i<=number_of_v;i++){
	    	result=rtn[i].charAt(j);
	    	if(result!='8')res+=result;
	    	result=rtn[i].charAt(numRows*2-2-j);
	    	if(result!='8')res+=result;
	    }
	    
	    for(i=0;i<=number_of_v;i++){
	    	result=rtn[i].charAt(numRows-1);
	    	if(result!='8')res+=result;
	    }
	    
	    return res;

	    
	}
	
	
	
}