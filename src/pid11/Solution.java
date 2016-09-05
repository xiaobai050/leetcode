package pid11;

public class Solution {
	int[] height;
	int maxAreaValue = 0;

	public int maxArea(int[] height) {
		this.height = height;
		int begin = 0, end = height.length-1;
		if(end==-1)return 0;
		int beginTemp = begin, endTemp = end;
		updateMaxArea(begin, end);
		while (begin != endTemp && end != beginTemp) {
			if (height[begin] > height[end]) {
				endTemp--;
				if (height[endTemp] > height[end]) {
					end = endTemp;
					updateMaxArea(begin, end);
				}
			} else {
				beginTemp++;
				if (height[beginTemp] > height[begin]) {
					begin = beginTemp;
					updateMaxArea(begin, end);
				}
			}
		}
		return maxAreaValue;
	}

	private void updateMaxArea(int begin, int end) {
		int a = height[begin];
		int b = height[end];
		int value;
		if (a > b)
			value = b * (end - begin);
		else
			value = a * (end - begin);
		if (value > maxAreaValue)
			maxAreaValue = value;
	}

}