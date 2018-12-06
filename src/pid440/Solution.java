package pid440;

import pid108.TreeNode;

public class Solution {

	TreeNode head = new TreeNode(1);
	int count =0;
	int k=0;
	int rtn = 0;
    public int findKthNumber(int n, int k) {

    	this.k=k;
    	TreeNode head = new TreeNode(1);
    	for(int i=2;i<=n;i++){
    		insertUnder(head,i);
    	}
    	
    		
    	display(head);
        return rtn;
    }
    
    public void insertUnder(TreeNode node,int num){
    	TreeNode next =cmp(node.val,num)?
    			node.left:node.right;
    	if(next==null){
    		next = new TreeNode(num);
    		if(cmp(node.val,num))
    			node.left=next;
    		else
    			node.right=next;
    	}
    	else insertUnder(next,num);
    }
    
    public void display(TreeNode node){
    	
    	if(node==null)
    		return;
    	display(node.left);
    	count++;
//    	System.out.print(node.val);
//    	System.out.println("    "+(count));
    	if(count == k)rtn=node.val;
    	display(node.right);
    }
    public boolean cmp(int nodeVal,int num){
    	
    	return String.valueOf(nodeVal).compareTo(String.valueOf(num))==1?true:false;
    	
    	
    }
}