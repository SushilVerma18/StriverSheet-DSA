class Solution {

    public boolean checkB(int[] bloomDay, int day,int k,int m){
        int count=0;
        int bouq = 0;
        int n = bloomDay.length;

        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){
                count++;
            }
            else{
                bouq += (count/k); 
                count =0;
            }
        }

        bouq += (count/k);
        
        return bouq >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int n : bloomDay){
           max= Math.max(n,max);
           min = Math.min(n,min);
        }
        if ((long)m * k > bloomDay.length) {
            return -1;
        }

        int low =min;
        int high = max;
        int ans =0;

        while(low<=high){
            int mid = low + (high - low) / 2;
            boolean verifyDay = checkB(bloomDay,mid,k,m);

            if(verifyDay){
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