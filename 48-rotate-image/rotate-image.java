class Solution {
    public void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    public void reverseRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n =matrix.length;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j,j,i);
            }
        }
        
        reverseRows(matrix);
    }
}