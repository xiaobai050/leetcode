package pid174;

import java.util.Arrays;

/**
 * 174.Dungeon Game
 * 
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0's) or
 * contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 * -2 (K) 	-3 		3 
 * -5 		-10 	1 
 * 10 		30 		-5 (P)
 * 
 * Notes:
 * 
 * The knight's health has no upper bound. Any room can contain threats or
 * power-ups, even the first room the knight enters and the bottom-right room
 * where the princess is imprisoned.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		int[][][] testTable = { 
				{ { 0 } },
				{
					{-2,-3,3},
					{-5,-10,1},
					{10,30,-5}
				}
		};
		for (int ito[][] : testTable) {
			test(ito);
		}
	}

	private static void test(int[][] ito) {
		for (int i = 0; i < ito.length; i++)
			System.out.println(Arrays.toString(ito[i]));

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		int rtn = solution.calculateMinimumHP(ito);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println(rtn);
		System.out.println("ºÄÊ±£º" + (end - begin) + "ms");
		System.out.println("--------------");
	}
}
