class Solution {

    public boolean checkCapacity(int[] weights, int days, int capacity) {

    int shippingDay = 1;
    int currentWeight = 0;

    for (int weight : weights) {

        if (currentWeight + weight <= capacity) {
            currentWeight += weight;
        } else {
            shippingDay++;
            currentWeight = weight;
        }
    }

    return shippingDay <= days;
}

    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int w : weights){
            max = Math.max(w,max);
            sum+=w;
        }

        int low = max;
        int high = sum;
        int ans =0;

        while(low<=high){
            int mid = low + (high - low )/2;
            boolean capacity = checkCapacity(weights,days,mid);

            if(capacity){
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