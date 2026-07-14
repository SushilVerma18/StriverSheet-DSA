class Solution {
    int firstOcc(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                ans = mid;
                high = mid-1;
            }
            else if(nums[mid]< target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    int lastOcc(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                ans = mid;
                low = mid+1;
            }
            else if(nums[mid]< target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {

        int first = firstOcc(nums,target);
        int last = lastOcc(nums,target);


        return new int[]{first,last};
    }
}