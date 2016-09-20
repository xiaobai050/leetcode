package pid121;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int maxSub=0;
        int minNum=prices[0];
        for(int ito:prices){
            minNum=min(minNum,ito);
            maxSub=max(ito-minNum,maxSub);
        }
        return maxSub;
    }
    
    public int min(int i,int j) {
        return i<j?i:j;
    }
    
    public int max(int i,int j) {
        return i>j?i:j;
    }
}