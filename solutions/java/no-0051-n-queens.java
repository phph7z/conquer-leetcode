// @desc-start
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
//  
// Example 1:
// 
// 
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
// 
// Example 2:
// 
// Input: n = 1
// Output: [["Q"]]
// 
//  
// Constraints:
// 
// 1 <= n <= 9
// 
// 
// @desc-end


// @code-start
class Solution {
	private List<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for(int i =0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		placeQueen(n, 0, board);
		return solutions;
    }

	public void placeQueen(int n, int row, char[][] board) {
		if(row == n) {
			List<String> solution = new ArrayList<>();
			for(int i = 0; i < n; i ++) {
				solution.add(new String(board[i]));
			}
			solutions.add(solution);
			return;
		}
		for(int j = 0; j < n; j ++) {
			if(!isValid(n, board, row, j))
				continue;
			board[row][j] = 'Q';
			placeQueen(n, row + 1, board);
			board[row][j] = '.';
		}
	}

	public boolean isValid(int n, char[][] board, int row, int col) {
		// check column
		for(int i = 0; i < row; i ++) {
			if(board[i][col] == 'Q')
				return false;
		}
		for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] == 'Q')
				return false;
		}
		for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
			if(board[i][j] == 'Q')
				return false;
		}
		return true;
	}
}
// @code-end
