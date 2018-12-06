package pid407;

import java.util.Arrays;

public class Solution {

	int[][] heightMap;
	int[][] filledWithWater;
	int[][][] memory;	// == 1����ˮ 
						// == 0����û̽���� 
						// ==-1������ûˮ
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
		
//		visit(1, 1, 1, 1 ,30000);	//��Ŀ˵�߶Ⱦ�С��20000
		
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

		int begin=heightMap[rowFirst][columnFirst];	//��ʼ�߶�
		int now=heightMap[row][column];  			//���ڸ߶�
		
		if(row==0||row==rowMax-1||column==0||column==columnMax-1)		 //ǽ��	
			return min(wallMin,now);	
		
		if(now>begin) return wallMin;	//���ߣ�			
		
		if(wallMin<=now&&now>=begin){				//��©ˮ��
			memory[now][row][column]=-1;
			return wallMin;				
		}
		
		if(memory[now][row][column]==1) return wallMin;  //������
		
			
	
		
		if(now<begin){		//��������Ŀӣ���������ȥ
			if(memory[now][row][column]==-1){	//����©ˮ��
				memory[begin][row][column]=-1;
				return wallMin;
				}
			else wallMin=visit(row , column, row , column, wallMin);	//���ǽ������֮ǰ�ĸ߶ȿ�ʼ��
		}


		

//		System.out.print("  rowFirst="+rowFirst);
//		System.out.print("  columnFirst="+columnFirst);
//		System.out.print("  row="+row);
//		System.out.println("  column="+column);
		
		if(memory[now][row-1][column]==-1||memory[now][row+1][column]==-1||memory[now][row][column-1]==-1||memory[now][row][column+1]==-1)memory[now][row][column]=-1;else wallMin=visit(rowFirst, columnFirst, row - 1, column, wallMin); // ��
		if(memory[now][row-1][column]==-1||memory[now][row+1][column]==-1||memory[now][row][column-1]==-1||memory[now][row][column+1]==-1)memory[now][row][column]=-1;else wallMin=visit(rowFirst, columnFirst, row + 1, column, wallMin); // ��
		if(memory[now][row-1][column]==-1||memory[now][row+1][column]==-1||memory[now][row][column-1]==-1||memory[now][row][column+1]==-1)memory[now][row][column]=-1;else wallMin=visit(rowFirst, columnFirst, row, column - 1, wallMin); // ��
		if(memory[now][row-1][column]==-1||memory[now][row+1][column]==-1||memory[now][row][column-1]==-1||memory[now][row][column+1]==-1)memory[now][row][column]=-1;else wallMin=visit(rowFirst, columnFirst, row, column + 1, wallMin); // ��


		
		//������������,û�и���Ŀӣ���ӵ��������ˡ����ص����
		if(wallMin<=begin)				//����������©��
			memory[begin][row][column]=-1;	//��ǣ�-1----���ﲻ������ˮ
		else{							//û����©��
			memory[begin][row][column]=1;	//��ǣ�  1----����
			if(wallMin!=30000)
				sum+=wallMin-begin;
		}
		
		return wallMin;
	}




	private int min(int i, int j) {
		return i<j?i:j;
	}
}
