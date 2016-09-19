package pid36;

/**
 * Valid Sudoku Determine if a Sudoku is valid, according to: Sudoku Puzzles -
 * The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		String[][] table = {
				{ ".87654321", "2.7......", "3........", "4........", "5........", "6........", "7........",
						"8........", "9.1......" },
				{ ".87654321", "2........", "3........", "4........", "5........", "6........", "7........",
						"8........", "9.7......" },
				{ ".87654321", "2........", "3........", "4........", "5........", "6........", "7........",
						"8........", "9.9......" },

		};
		for (String[] ito : table)
			test(ito);
	}

	private static void test(String[] table) {
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			board[i] = table[i].toCharArray();
		}
		Solution solution = new Solution();
		boolean rtn;
		rtn = solution.isValidSudoku(board);
		System.out.println(rtn);
	}

}
