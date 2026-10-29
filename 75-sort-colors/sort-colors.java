class Solution {

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        int k = 0;

        while(k <= h){
            if(nums[k]==0){
                swap(nums,k,l);
                k++;
                l++;
            }
            else if(nums[k]==2){
                swap(nums,h,k);
                h--;
            }
            else{
                k++;
            }
        }
    }
}