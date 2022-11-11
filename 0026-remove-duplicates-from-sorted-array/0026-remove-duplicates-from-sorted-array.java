class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        int cnt=0;
        for(int i=0; i < nums.length-1; i++)
        {
           if(nums[i] != nums[i+1])
               nums[cnt++] = nums[i];
        }
        nums[cnt++] = nums[nums.length-1];
        return cnt;
    }
}