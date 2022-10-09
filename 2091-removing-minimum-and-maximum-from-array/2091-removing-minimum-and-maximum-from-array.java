class Solution {
    public int minimumDeletions(int[] nums) {
        int maxIndex = 0;
        int minIndex = 0;
        for(int i =1; i < nums.length; i++){
            if(nums[i] >  nums[maxIndex]){
                maxIndex = i;
            }
            else if(nums[i] < nums[minIndex]){
                minIndex = i;
            }
        }
        
        
        int numOfDelFromLeft = Math.max(maxIndex, minIndex) + 1;
        int numOfDelFromRight = nums.length - Math.min(maxIndex, minIndex);
        int numOfDelFromLeftAndRight = (Math.min(maxIndex, minIndex) + 1) + (nums.length - Math.max(maxIndex, minIndex)) ;
        
        return Math.min(numOfDelFromLeftAndRight , ( Math.min(numOfDelFromLeft, numOfDelFromRight) ));
    }
}