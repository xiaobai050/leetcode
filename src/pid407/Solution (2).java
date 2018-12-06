package pid407;

import java.util.Arrays;

public class Solution {

	int[][] heightMap;
	int[][] filledWithWater;
	int[][][] memory;	// == 1：有水 
						// == 0：还没探索过 
						// ==-1：绝对没水
	int sum=0;
	int rowMax;
	int columnMax;

	public int trapRainWater(int[][] heightMap) {
		rowMax = heightMap.length;
		if (rowMax < 3)
			return 0;
		columnMax = heightMap[0].length;
		if (columnMax < 3)
			return 0;

		this.heightMap = heightMap;
		this.filledWithWater = heightMap;
		
		this.memory=new int[20001][rowMax][columnMax];
		
//		visit(1, 1, 1, 1 ,30000);	//题目说高度均小于20000
		
		for(int row=1;row<rowMax-1;row++)
			for(int column=1;column<columnMax-1;column++){
				if(memory[heightMap[row][column]][row][column]==0)
					visit(row, column, row, column ,30000);			
						
			}
		
		for(int i=0;i<5;i++){
			for(int []ito:memory[i])
				System.out.println(Arrays.toString(ito));
			System.out.println();
		}
		return sum;

	}

	public int visit(int rowFirst,int columnFirst, int row, int column,int wallMin) {

		int begin=heightMap[rowFirst][columnFirst];	//初始高度
		int now=heightMap[row][column];  			//现在高度
		
		if(row==0||row==rowMax-1||column==0||column==columnMax-1)		 //墙？	
			return min(wallMin,now);	
		
		if(now>begin) return wallMin;	//更高？			
		
		if(wallMin<=now&&now>=begin){				//这漏水？
			memory[now][row][column]=-1;
			return wallMin;				
		}
		
		if(memory[now][row][column]==1) return wallMin;  //来过？
		
			
	
		
		if(now<begin){		//看到更深的坑，继续跳进去
			if(memory[now][row][column]==-1){	//下面漏水？
				memory[begin][row][column]=-1;
				return wallMin;
				}
			else wallMin=visit(row , column, row , column, wallMin);	//最低墙从跳坑之前的高度开始算
		}


		

//		System.out.print("  rowFirst="+rowFirst);
//		System.out.print("  columnFirst="+columnFirst);
//		System.out.print("  row="+row);
//		System.out.println("  column="+column);
		
		if(memory[now][row-1][column]==-1||memory[now][row+1][column]==-1||memory[now][row][column-1]==-1||memory[now][row][column+1]==-1)memory[now][row][column]=-1;else wallMin=visit(rowFirst, columnFirst, row - 1, column, wallMin); // 上
		if(memory[now][row-1][column]==-1||memory[now][row+1][column]==-1||memory[now][row][column-1]==-1||memory[now][row][column+1]==-1)memory[now][row][column]=-1;else wallMin=visit(rowFirst, columnFirst, row + 1, column, wallMin); // 下
		if(memory[now][row-1][column]==-1||memory[now][row+1][column]==-1||memory[now][row][column-1]==-1||memory[now][row][column+1]==-1)memory[now][row][column]=-1;else wallMin=visit(rowFirst, columnFirst, row, column - 1, wallMin); // 左
		if(memory[now][row-1][column]==-1||memory[now][row+1][column]==-1||memory[now][row][column-1]==-1||memory[now][row][column+1]==-1)memory[now][row][column]=-1;else wallMin=visit(rowFirst, columnFirst, row, column + 1, wallMin); // 右


		
		//横向搜索结束,没有更深的坑，或坑底搜索遍了【返回到这里】
		if(wallMin<=begin)				//发现下面有漏口
			memory[begin][row][column]=-1;	//标记：-1----这里不可能有水
		else{							//没发现漏口
			memory[begin][row][column]=1;	//标记：  1----来过
			if(wallMin!=30000)
				sum+=wallMin-begin;
		}
		
		return wallMin;
	}




	private int min(int i, int j) {
		return i<j?i:j;
	}
}
