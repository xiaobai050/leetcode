package pid74;

public class Solution {
	
	public static void main(String[] args) {
		
		Solution m=new Solution();	
		
		int[][] matrix=
			{		                
			  {1,   3,  5,  7},
			  {10, 11, 16, 20},
			  {23, 30, 34, 50}
			};
		int target=0;
		
		for(target=-2;target<60;target++)
			{
				boolean rtn=m.searchMatrix(matrix, target);
				if(rtn)System.out.println("there is   " +target);
			}
			//System.out.println("rtn :" + rtn);
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		boolean rtn=false;
		int hang=matrix.length;
		int lie=matrix[0].length;
		for(int i=0;i<hang;i++)
		{
			if(matrix[i][lie-1]<target)continue;
			{
				for(int j=0;j<lie;j++)
				{
					if((matrix[i][j]<target))continue;
					if((matrix[i][j]==target))
						rtn=true;
						//System.out.print("  " +matrix[i][j]);
				}
			}
		}
	    return rtn;
	}
	
	
	
	
	
}