class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int concatArr[] = new int[2*n];

        for(int i=0;i<n;i++){
            concatArr[i]=nums[i];
            concatArr[i+n] = nums[i];
        }

        return concatArr;
    }
}