/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
package pid278;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int begin=1;
        int end=n;
        
        while(begin<end-1){
            int middle=begin/2+end/2+(begin%2+end%2)/2;
            if(isBadVersion(middle))end=middle;
            else begin=middle;
        }
        
        if(isBadVersion(begin))return begin;
        return end;
    }


}