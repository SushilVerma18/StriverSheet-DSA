class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left=0;
        int right = n-1;
        int h = 0;
        int ans = 0;

        while(left<right){
            h = Math.min(height[left],height[right]);
            int width = right - left;
            ans = Math.max(ans,h * width);
            if(height[left]<height[right]) left++;
            else right--;
    
        }

        return ans;
    }
}