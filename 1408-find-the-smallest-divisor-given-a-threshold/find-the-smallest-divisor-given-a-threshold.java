class Solution {

    public boolean checkDivisor(int[] nums, int threshold, int divisor){
        int divSum = 0;
        for(int n : nums ){
            divSum += (n + divisor - 1) / divisor;
        }
        return divSum<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        
        int max = Integer.MIN_VALUE;
        int ans =0;

        for(int n : nums){
           max= Math.max(n,max);
           
        }

        int low = 1;
        int high = max;

        while(low<=high){
            int mid = low + (high - low)/2;
            boolean div = checkDivisor(nums,threshold,mid);
            
            if(div){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }
}