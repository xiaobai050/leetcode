package pid11;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * 
 * @author ��
 *
 */
public class main {
	public static void main(String[] args) {
		int[][] heightTable = {
				{},
				{1,2},
				{0,1,1,1},
				};
		for (int[] ito : heightTable) {
			test(ito);
		}
	}

	private static void test(int[] height) {
		Solution solution = new Solution();
		int maxAreaValue=solution.maxArea(height);
		System.out.println(maxAreaValue);
		
//		long startMili = System.currentTimeMillis();// ��ǰʱ���Ӧ�ĺ�����
//		long endMili = System.currentTimeMillis();
//		System.out.println("������ʱΪ��" + (endMili - startMili) + "����");

		// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// for (int i = 0; i < height.length; i++)
		// map.put(i + 1, height[i]);
		// System.out.println(map);

	}
}
