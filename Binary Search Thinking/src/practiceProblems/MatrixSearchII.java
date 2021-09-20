package practiceProblems;

public class MatrixSearchII {
	//Runtime: 6 ms, faster than 35.76% of Java online submissions for Search a 2D Matrix II.
	//Memory Usage: 44.4 MB, less than 80.52% of Java online submissions for Search a 2D Matrix II.
	public static boolean solution1(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		int i = 0, j = col - 1;
		int left, right, mid;
		while (j >= 0 && i < row) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] < target) {
				// i,j to row-1, j
				// mid = i + ((row - 1 - i)/2)
				left = i;
				right = row - 1;
				while (left <= right) {
					mid = left + ((right - left) / 2);
					if (matrix[mid][j] == target)
						return true;
					else if (matrix[mid][j] < target) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
			} else {
				// i,0 to i,j
				left = 0;
				right = j;
				while (left <= right) {
					mid = left + ((right - left) / 2);
					if (matrix[i][mid] == target)
						return true;
					else if (matrix[i][mid] < target) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}

			}

			++i;
			--j;
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
		int target = 26;
		System.out.println(solution1(matrix, target));
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.println(i + "," + j + ": " + solution1(matrix, matrix[i][j]));
			}
		}

	}

}
