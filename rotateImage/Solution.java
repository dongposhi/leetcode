public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;

		for(int j = 0;j< n/2 + 1;j++){
			for(int i = j;i<n-j;i++){
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[n-i][j];
				matrix[n-i][j] = matrix[n-j][n-i];
				matrix[n-j][n-i] = matrix[i][n-j];
				matrix[i][n-j] = tmp;
			}
		}
	
    }
}
