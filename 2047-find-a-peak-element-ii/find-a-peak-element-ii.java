class Solution {
    int findMax(int[][] mat,int mid){
        int maxRow = 0;
        for(int i=0;i<mat.length;i++){
            if(mat[i][mid]>mat[maxRow][mid]){
                maxRow = i;
            }
        }
        return maxRow;
    }  
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m-1;

        while(low<=high){
            int mid = low + (high - low)/2;
          

            int maxRowInd = findMax(mat,mid);

            int left = (mid == 0) ? -1 : mat[maxRowInd][mid - 1];
            int right = (mid == m - 1) ? -1 : mat[maxRowInd][mid + 1];
            if(mat[maxRowInd][mid] > left && mat[maxRowInd][mid] > right){
                return new int[]{maxRowInd,mid};
            }
            else if(mat[maxRowInd][mid]<left){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return new int[]{-1,-1};
        
    }
}