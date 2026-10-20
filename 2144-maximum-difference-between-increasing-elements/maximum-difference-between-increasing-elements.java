class Solution {
    public int maximumDifference(int[] nums) {
        if(nums.length<2) return -1;
        int maxDif = -1;
        int i = 0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]<nums[j]){
                maxDif = Math.max(maxDif,nums[j]-nums[i]);
            }
            else if(nums[i]>nums[j]){
                i=j;
            }
        }

        
        return maxDif;
    }
}