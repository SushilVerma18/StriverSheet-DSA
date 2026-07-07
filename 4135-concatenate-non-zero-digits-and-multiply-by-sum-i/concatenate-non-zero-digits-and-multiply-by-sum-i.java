class Solution {
    public void reverse(int sum){
       
    }
    public long sumAndMultiply(int n) {
        int divisor = 1;
        while (n / divisor >= 10) {
            divisor *= 10;
        }
        int sum=0;
        long x=0;
        while(divisor>0){
            int digit = n/divisor;
            
            if(digit!=0){
                x= x*10 + digit;
                sum+= digit;
                
            }
           
            n %= divisor;
            divisor/=10;
           
        }
        return  x * sum;
    }
}