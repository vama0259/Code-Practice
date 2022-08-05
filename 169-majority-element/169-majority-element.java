class Solution {
    public int majorityElement(int[] nums) {
        int maxCount = 0;
        int n = nums.length;
        int index = -1;
        for(int i =0; i < n; i++){
            int count = 1;
            for(int j = i+1; j < n; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
                index = i;
            }
        }
        
        return nums[index];
        
    }
}