class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int small = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(nums[i]<small){
                small = nums[i];
            }
            if(nums[i]>high){
                high = nums[i];
            }
        }

        int j = small;

        while(j>1){
            if(small % j == 0 && high % j ==0 ){
                return j;
            }
            j--;
        }

        return 1;
    }
}