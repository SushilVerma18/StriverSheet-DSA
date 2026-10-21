class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        int dist=0;
        for(int num : nums){
            if(dist==0){
                max = num;
                dist++;
            }
            else{
                if(num==max || num==max2 ){
                    continue;
                }
               else if(num>max){
                dist++;
                  max3 = max2;
                  max2 = max;
                  max = num;
              }
              else if(num>max2 && num<max){
                dist++;
                max3 = max2;
                max2 = num;
            }
            else if(num > max3 && num<max2){
                dist++;
                max3 = num;
                
            }
            }
        }

        if(dist<3 ) return (int) max;
        
        
        return (int) max3;
    }
}