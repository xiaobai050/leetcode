package pid389;

public class Solution {
    public char findTheDifference(String s, String t) {
        int []table=new int[26];
        int len=s.length();
        for(int i=0;i<len;i++)
            table[s.charAt(i)-'a']++;
            
        for(int i=0;i<=len;i++)
            if(--table[t.charAt(i)-'a']<0)
            return t.charAt(i);
        
        return ' ';
    }
}