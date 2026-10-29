class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        for(int i =0;i<=nums.length-k;i++){
            int sum = 0;
            for(int j = i;j<i+k;j++){
                sum += nums[j];
            }

            double avg = (double) sum/k;
            maxAvg = Math.max(maxAvg,avg); 
        }

        return maxAvg;
    }
}