class Solution {
    //Brute Force
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int arr[] = new int[n];

        if(k > 0){
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j = i+1;j<i+k+1;j++){
                    sum += code[j%n];
                }
                arr[i] = sum;
            }
        }
        else if(k < 0){
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j = i-1;j>=i+k;j--){
                    sum += code[(j+n)%n];
                }
                arr[i] = sum;
            }
        }
        else{
            return arr;
        }

        return arr;
    }
}