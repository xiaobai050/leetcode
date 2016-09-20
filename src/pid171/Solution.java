package pid171;

public class Solution {
    public int titleToNumber(String s) {
        int len=s.length();
        if(len==0)return 0;
        int rtn=0;
        for (int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(ch>='a'&&ch<='z')
                ch+=('A'-'a');
            rtn*=26;
            rtn+=ch-'A'+1;
            
        }
        return rtn;
    }
}