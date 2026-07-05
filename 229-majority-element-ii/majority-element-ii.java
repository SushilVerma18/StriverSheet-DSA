class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1 =0;
        int count1 =0;
        int el2 = 0;
        int count2 =0;

        int n=nums.length;
        for(int i=0;i<n;i++){
            if(count1==0 && el2!= nums[i]){
                el1=nums[i];
                count1++;
            }
            else if(count2==0 && el1 != nums[i]){
                el2=nums[i];
                count2++;
            }
            else if (el1==nums[i]){
                count1++;
            }
            else if (el2==nums[i]){
                count2++;
            }
            
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0; 
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1){
                count1++;
            }
              
            else if (nums[i] == el2){
                count2++;
            } 
        }
        int min = (n / 3 );

        List<Integer> list = new ArrayList<>();
        if(count1>min){
            list.add(el1);
        }
        if(count2>min && el1 != el2 ){
            list.add(el2);
        }

        return list;
    }
}