package pid329;

public class Solution {
	int[][] matrix;
	int[][] memory;
	int rowMax;
	int columnMax;
	int lenMax=0;
    public int longestIncreasingPath(int[][] matrix) {
    	
    	this.matrix = matrix;
    	rowMax=matrix.length;
    	if(rowMax==0)return 0;
    	columnMax=matrix[0].length;
    	this.memory= new int [rowMax][columnMax];
    	for(int i=0;i<rowMax;i++)
    		for(int j=0;j<columnMax;j++)
    			solve(i,j);    		
		
		return lenMax;
    }

	private int solve(int i, int j) {
		if(memory[i][j]!=0)return memory[i][j];		
		
		int value=0;
		
		if(hasBigger(i,j,i-1,j))value=max(value,solve(i-1,j)); //ио
		if(hasBigger(i,j,i+1,j))value=max(value,solve(i+1,j)); //об
		if(hasBigger(i,j,i,j-1))value=max(value,solve(i,j-1)); //вС
		if(hasBigger(i,j,i,j+1))value=max(value,solve(i,j+1)); //ср
		
		value++;
		
		memory[i][j]=value;
		
		lenMax=max(lenMax,value);		
		
		return value;
	}
	
	private int max(int i, int j) {
		return i>j?i:j;
	}

	private boolean hasBigger(int i, int j, int x2, int y2) {		
		if(!checkout(x2,y2))return false;
		if(matrix[x2][y2]>matrix[i][j])return true;
		return false;
	}
	

	private boolean checkout(int x2, int y2) {
		if(x2>rowMax-1)return false;
		if(x2<0)return false;
		if(y2>columnMax-1)return false;
		if(y2<0)return false;
		return true;
	}
}
