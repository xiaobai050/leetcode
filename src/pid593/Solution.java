package me.bai.LeetCode.pid593;

/**
 * Given the coordinates of four points in 2D space, return whether the four
 * points could construct a square.
 * 
 * The coordinate (x,y) of a point is represented by an integer array with two
 * integers.
 * 
 * Example: Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1] Output: True
 * Note:
 * 
 * All the input integers are in the range [-10000, 10000]. A valid square has
 * four equal sides with positive length and four equal angles (90-degree
 * angles). Input points have no order.
 */
public class Solution {
	int[] O;
	int[] A;
	int[] B;
	int[] C;

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		p4[0] -= p1[0];
		p4[1] -= p1[1];
		p3[0] -= p1[0];
		p3[1] -= p1[1];
		p2[0] -= p1[0];
		p2[1] -= p1[1];
		p1[0] -= p1[0];
		p1[1] -= p1[1];

		O = p1;

		if (isNeighborAtO(p2, p3)) {
			A = p2;
			C = p3;
			B = p4;
		} else if (isNeighborAtO(p2, p4)) {
			A = p2;
			C = p4;
			B = p3;
		} else if (isNeighborAtO(p3, p4)) {
			A = p3;
			C = p4;
			B = p2;
		} else {
			return false;
		}

		return B[0] == A[0] + C[0] && B[1] == A[1] + C[1] &&( B[0] != 0 || B[1] != 0);

	}

	private boolean isNeighborAtO(int[] M, int[] N) {
		return (-M[0] == N[1] && M[1] == N[0]) || (M[0] == N[1] && -M[1] == N[0]);
	}

	public static void main(String[] args) {
		new Solution().test();
	}

	private void test() {
		int[] p1 = new int[] { 0, 0 };
		int[] p3 = new int[] { 1, 5 };
		int[] p2 = new int[] { 6, 4 };
		int[] p4 = new int[] { 5, -1 };
		boolean rtn = validSquare(p1, p2, p3, p4);
		System.out.println(rtn);
	}
}
