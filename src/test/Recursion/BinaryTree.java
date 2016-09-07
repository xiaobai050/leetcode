package test.Recursion;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	List<Integer> tree=new ArrayList<Integer>();
	public void solve (int n){
		
		set(1,5,1,1);		
		System.out.println(tree);
//		Preorder(1,n);
//		System.out.println(tree);
//		System.out.println();
//		
//		After(1,n);
	}

	private void set(int line,int maxLine,int value,int volume) {	//建立一個二叉樹，從左至右1~2^n
		if(line>maxLine){
			return;
		}
		for(int i=0;i<volume;i++,value++){
			tree.add(value);
		}
		set(line+1,maxLine,value,volume*2);
		
	}

	private void Preorder(int index,int n) {
		if(index==n){
			return;
		}
		//tree.add(index);
		System.out.println(tree.get(index));
		Preorder(index+1,n);		
	}
	
	private void After(int index,int n) {
		if(index==n){
			return;
		}
		
		System.out.println(tree.get(index-1));
		After(index+1,n);		
	}
}
