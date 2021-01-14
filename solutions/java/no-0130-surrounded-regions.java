// @desc-start
// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
// Example:
// 
// X X X X
// X O O X
// X X O X
// X O X X
// 
// After running your function, the board should be:
// 
// X X X X
// X X X X
// X X X X
// X O X X
// 
// Explanation:
// Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
// 
// @desc-end


// @code-start
class Solution {
	int[][] DIRS = new int[][] {
		{-1,0},
		{1,0},
		{0,-1},
		{0,1}
	};
    public void solve(char[][] board) {
		int m = board.length;
		if(m == 0) return;
		int n = board[0].length;
		if(n == 0) return;
		for(int i=0;i<m;i++) {
			bfs(board, i, 0);
			bfs(board, i, n-1);
		}
		for(int j=1;j<n-1;j++) {
			bfs(board, 0, j);
			bfs(board, m-1, j);
		}
		for(int i=0;i<m;i++) 
			for(int j=0;j<n;j++) 
				if(board[i][j] == 'O') board[i][j] = 'X';

		for(int i=0;i<m;i++) 
			for(int j=0;j<n;j++) 
				if(board[i][j] == 'M') board[i][j] = 'O';
    }

	private void bfs(char[][] board, int i, int j) {
		if(board[i][j] == 'X') return;
		board[i][j] = 'M';
		for(int[] dir : DIRS) {
			int newI = i+dir[0]; int newJ = j+dir[1];
			if(isInBoard(board, newI, newJ) && board[newI][newJ] == 'O') bfs(board, newI, newJ);
		}
	}

	private boolean isInBoard(char[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		return i >=0 && i <m && j>=0 && j<n;
	}
}
// @code-end
