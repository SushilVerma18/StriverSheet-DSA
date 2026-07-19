class Solution {
    public long calHour(int[] piles, int mid){
        int n = piles.length;
        long totalH = 0;

        for (int pile : piles) {
            totalH += (pile + mid - 1L) / mid;
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int ans =0;
        int low = 1;
        int high = maxPile;

        while(low <= high){
            int mid = (low + high) / 2;
            long eatPile = calHour(piles,mid);

            if(eatPile <= h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;

    }
}