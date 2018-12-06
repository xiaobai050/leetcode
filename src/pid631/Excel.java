package me.bai.LeetCode.pid631;

import java.util.List;

import me.bai.LeetCode.pid631.copy.ExcelCopy;

import java.util.LinkedList;

/**
 * 631. Design Excel Sum Formula My SubmissionsBack To Contest User Accepted: 32
 * User Tried: 145 Total Accepted: 32 Total Submissions: 348 Difficulty: Hard
 * Your task is to design the basic function of Excel and implement the function
 * of sum formula. Specifically, you need to implement the following functions:
 * 
 * Excel(int H, char W): This is the constructor. The inputs represents the
 * height and width of the Excel form. H is a positive integer, range from 1 to
 * 26. It represents the height. W is a character range from 'A' to 'Z'. It
 * represents that the width is the number of characters from 'A' to W. The
 * Excel form content is represented by a height * width 2D integer array C, it
 * should be initialized to zero. You should assume that the first row of C
 * starts from 1, and the first column of C starts from 'A'.
 * 
 * 
 * void Set(int row, char column, int val): Change the value at C(row, column)
 * to be val.
 * 
 * 
 * int Get(int row, char column): Return the value at C(row, column).
 * 
 * 
 * int Sum(int row, char column, List of Strings : numbers): This function
 * calculate and set the value at C(row, column), where the value should be the
 * sum of cells represented by numbers. This function return the sum result at
 * C(row, column). This sum formula should exist until this cell is overlapped
 * by another value or another sum formula.
 * 
 * numbers is a list of strings that each string represent a cell or a range of
 * cells. If the string represent a single cell, then it has the following
 * format : ColRow. For example, "F7" represents the cell at (7, F).
 * 
 * If the string represent a range of cells, then it has the following format :
 * ColRow1:ColRow2. The range will always be a rectangle, and ColRow1 represent
 * the position of the top-left cell, and ColRow2 represents the position of the
 * bottom-right cell.
 * 
 * 
 * Example 1: Excel(3,"C"); // construct a 3*3 2D array with all zero. // A B C
 * // 1 0 0 0 // 2 0 0 0 // 3 0 0 0
 * 
 * Set(1, "A", 2); // set C(1,"A") to be 2. // A B C // 1 2 0 0 // 2 0 0 0 // 3
 * 0 0 0
 * 
 * Sum(3, "C", ["A1", "A1:B2"]); // set C(3,"C") to be the sum of value at
 * C(1,"A") and the values sum of the rectangle range whose top-left cell is
 * C(1,"A") and bottom-right cell is C(2,"B"). Return 4. // A B C // 1 2 0 0 //
 * 2 0 0 0 // 3 0 0 4
 * 
 * Set(2, "B", 2); // set C(2,"B") to be 2. Note C(3, "C") should also be
 * changed. // A B C // 1 2 0 0 // 2 0 2 0 // 3 0 0 6 Note: You could assume
 * that there won't be any circular sum reference. For example, A1 = sum(B1) and
 * B1 = sum(A1). The test cases are using double-quotes to represent a
 * character. Please remember to RESET your class variables declared in class
 * Excel, as static/class variables are persisted across multiple test cases.
 * Please see here for more details.
 */
public class Excel {

	public static void main(String[] args) {
		ExcelCopy obj = new ExcelCopy(5, 'E');
		obj.set(1, 'A', 5);
		obj.set(1, 'B', 3);
		obj.set(1, 'C', 2);
		obj.sum(1, 'C', new String[] { "A1", "A1:B1" });
		obj.set(1, 'B', 5);
		obj.sum(1, 'B', new String[] { "A1:A5" });
		obj.set(5, 'A', 10);
		obj.sum(3, 'C', new String[] { "A1:C1", "A1:A5" });
		obj.set(3, 'A', 3);
		int rtn = obj.get(3, 'A');
		System.out.println(rtn);
	}

	private static void printTable() {
		for (int r = 1; r < table.length; r++) {
			for (int c = 'A'; c < table[0].length; c++) {
				System.out.print(table[r][c] + "	");
			}
			System.out.println();
		}
		System.out.println("==================================");
	}

	public Excel(int H, char W) {
		table = new Cell[H + 1][W + 1];
		for (int r = 1; r < table.length; r++) {
			for (int c = 'A'; c < table[0].length; c++) {
				table[r][c] = new Cell();
			}
		}
	}

	public void set(int r, char c, int v) {
		Cell target = table[r][c];
		target.cancelAll();
		target.setVal(v);
	}

	public int get(int r, char c) {
		return table[r][c].getVal();
	}

	public int sum(int r, char c, String[] strs) {
		Cell target = table[r][c];
		target.cancelAll();
		target.setVal(0);
		// Set <String >set =new HashSet<String>();
		for (String str : strs) {
			// if (set.contains(str))
			// continue;
			// set.add(str);
			if (str.split(":").length == 1) {
				target.subscribe(getCell(str));
			} else {
				String leftTop = str.split(":")[0];
				String rightBottom = str.split(":")[1];
				for (int rr = rOf(leftTop); rr <= rOf(rightBottom); rr++) {
					for (char cc = cOf(leftTop); cc <= cOf(rightBottom); cc++) {
						target.subscribe(table[rr][cc]);
					}
				}
			}
		}

		return target.getVal();
	}

	private int rOf(String singleStr) {
		return Integer.valueOf(singleStr.substring(1));
	}

	private char cOf(String singleStr) {
		return singleStr.charAt(0);
	}

	private Cell getCell(String singleStr) {
		int r = rOf(singleStr);
		char c = cOf(singleStr);
		return table[r][c];
	}

	static Cell[][] table = null;

	class Cell {
		private int val = 0;
		List<Cell> consumers = new LinkedList<Cell>();
		List<Cell> fathers = new LinkedList<Cell>();

		public Cell() {
		}

		public void subscribe(int r, int c) {
			Cell father = table[r][c];
			subscribe(father);
		}

		public void subscribe(Cell father) {
			father.addConsumer(this);
			fathers.add(father);
		}

		private void addConsumer(Cell consumer) {
			consumers.add(consumer);
			consumer.addVal(val);
		}

		private void cancelAll() {
			for (Cell father : fathers) {
				father.cancel(this);
			}
		}

		private void cancel(Cell son) {
			consumers.remove(son);
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			int zeng = val - this.val;
			this.val = val;
			for (Cell consumer : consumers) {
				consumer.addVal(zeng);
			}
		}

		private void addVal(int zeng) {
			setVal(val + zeng);
		}

		@Override
		public String toString() {
			return "" + val;
		}
	}
}

/**
 * Your Excel object will be instantiated and called as such: Excel obj = new
 * Excel(H, W); obj.set(r,c,v); int param_2 = obj.get(r,c); int param_3 =
 * obj.sum(r,c,strs);
 */
