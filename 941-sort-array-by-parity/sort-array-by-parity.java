class Solution {

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArrayByParity(int[] nums) {
        int even = 0;
        int odd = nums.length-1;

        while(even<odd){
            if(nums[even]%2!=0){
                swap(nums,even,odd);
                odd--;
            }
            else{
                even++;
            }
        }
        return nums;
    }
}