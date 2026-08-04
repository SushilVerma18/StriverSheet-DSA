class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            set.add(nums[i]);

        }

        List<Integer> ans = new ArrayList<>();

        for(int j=min + 1;j < max;j++){
            if(!set.contains(j)) ans.add(j);
        }

        return ans;
    }
}