class Solution {
    public int missingInteger(int[] nums) {

        // Step 1: Find sum of the longest sequential prefix
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Step 2:
        // Every number in nums is <= 50.
        // So if sum > 50, sum cannot exist in nums.
        if (sum > 50) {
            return sum;
        }

        // Step 3: Mark numbers that exist in nums
        boolean[] present = new boolean[51];

        for (int num : nums) {
            present[num] = true;
        }

        // Step 4: Find smallest missing number >= sum
        while (sum <= 50 && present[sum]) {
            sum++;
        }

        return sum;
    }
}