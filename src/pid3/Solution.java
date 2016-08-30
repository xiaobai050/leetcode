package pid3;

import java.util.HashMap;

public class Solution {
	int maxLen=0;
	int thisLen=0;
	int lenOfStr=0;
	char thisChar=' ';
	int beginPos=0;
	public int lengthOfLongestSubstring(String s) {
		lenOfStr=s.length();
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		
		for(int thisPos=0;thisPos<lenOfStr;thisPos++){
			
			thisChar=s.charAt(thisPos);
			if(map.get(thisChar)==null){
				map.put(thisChar, thisPos);
			}
			else{
				int lastSameCharPos=map.get(thisChar);
				
				if(lastSameCharPos<beginPos){	//�ظ�λ���ڿ�ʼλ֮ǰ����������ֱ�Ӹ��¡�
				}
				else{	//�ظ�λ���ǿ�ʼλ���ڿ�ʼλ֮�󣺽��������㵱ǰ�γ��ȣ����������ֵ��
					
					thisLen=thisPos-beginPos;
					beginPos=lastSameCharPos+1;
					updateMaxLen();
				}
				map.put(thisChar,thisPos);
			}
			if(thisPos==lenOfStr-1){
				thisPos++;
				thisLen=thisPos-beginPos;
				updateMaxLen();
				}
		}
		System.out.println(maxLen);
		return maxLen;
	}
	
	
	
	
	public void updateMaxLen(){
		if (thisLen>maxLen){
			maxLen=thisLen;
		}
	}
	
}