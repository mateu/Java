public class MagicSquare {
	int n;
	int[][] magic_square;
	int cursor_row, cursor_col;

	public MagicSquare(int n) {
		this.n = n;
		this.magic_square = new int[n][n];
		this.setSeed();
	}

	private void setSeed() {
		int start_row = this.n - 1;
		int start_column = (this.n - 1) / 2;
		this.magic_square[start_row][start_column] = 1;
		this.cursor_row = start_row;
		this.cursor_col = start_column;
	}

	public int getSeed() {
		int start_row = this.n - 1;
		int start_column = (this.n - 1) / 2;
		return this.magic_square[start_row][start_column];
	}

	public int getCurrentValue() {
		return this.magic_square[this.cursor_row][this.cursor_col];
	}

	public boolean hasNextValue() {

		// Only time we don't attempt to fill standard row, col
		// is when we're in the lower right corner n-1, n-1
		if ( (this.cursor_row == (this.n - 1))
				&& (this.cursor_col == (this.n - 1)) ) {
			if (this.magic_square[n - 2][n - 1] > 0) {
				return true;
			} else {
				return false;
			}
		}
		// Try standard insert first, then check secondary insert
		// if first location already has a number.
		int next_standard_row = (this.cursor_row + 1) % n;
		int next_standard_col = (this.cursor_col + 1) % n;
		if (this.magic_square[next_standard_row][next_standard_col] > 0) {
			return true;
		} else {
			// Try one up
			//System.out.println("Tyring one row up");
			int next_secondary_row = this.cursor_row == 0 ? (n - 1)
					: this.cursor_row - 1;
			int next_secondary_col = this.cursor_col;
			if (this.magic_square[next_secondary_row][next_secondary_col] > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean setNextValue() {
		// Only time we don't attempt to fill standard row, col
		// is when we're in the lower right corner n-1, n-1
		if ((this.cursor_row == (this.n - 1))
				&& (this.cursor_col == (this.n - 1))) {
			if (this.magic_square[n - 2][n - 1] > 0) {
				// Shouldn't be here
				return false;
			} else {
				this.magic_square[n - 2][n - 1] = this.getCurrentValue() + 1;
				this.cursor_row = n - 2;
				this.cursor_col = n - 1;
				//System.out.println("Setting above lower right");
				return true;
			}
		}
		// Try standard insert first, then check secondary insert
		// if first location already has a number.
		int next_standard_row = (this.cursor_row + 1) % n;
		int next_standard_col = (this.cursor_col + 1) % n;
//		System.out.print("standard row, col: ");
//		System.out.print(next_standard_row);
//		System.out.print(", ");
//		System.out.print(next_standard_col);
//		System.out.println();
//		System.out.println(this.magic_square[next_standard_row][next_standard_col]);
		if (this.magic_square[next_standard_row][next_standard_col] > 0) {
			// System.out.println("next standard cell filled.  Trying secondary...");
			// Try one up
			int next_secondary_row = this.cursor_row == 0 ? (n - 1)
					: this.cursor_row - 1;
			int next_secondary_col = this.cursor_col;
			if (this.magic_square[next_secondary_row][next_secondary_col] > 0) {
				return false;
			} else {
				this.magic_square[next_secondary_row][next_secondary_col] = this.getCurrentValue() + 1;
				this.cursor_row = next_secondary_row;
				this.cursor_col = next_secondary_col;
				//System.out.println("Doing the secondary insert.");
				return true;
			}
		} else {
			//System.out.println("Standard insert");
			this.magic_square[next_standard_row][next_standard_col] = this.getCurrentValue() + 1;
			this.cursor_row = next_standard_row;
			this.cursor_col = next_standard_col;
			return true;
		}
	}

}