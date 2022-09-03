class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        int[] add = new int[10];
    int[] sub = new int[10];
     Deque<Integer> queue = new ArrayDeque<>();
    for (int num=0; num < 10; num++) {
        add[num] = (num+k > 9) ? -1: num+k;
         sub[num] = (num-k < 0) ? -1: num-k;
        if(num != 0)
         queue.offer(num);
    }
    
  
   
    for (int i = 1; i < n; i++) {
        
        int size = queue.size();
       while(size != 0) {
           
            int curr = queue.poll();
            size--;
            int mainNum = curr % 10;
            for (int j = 0; j < 10; j++) {
                if(Math.abs(mainNum - j) == k) {
                    queue.offer(curr*10+j);
                }
                
            }
        }
    }
    int[] result = new int[queue.size()];
    int index = 0;
     while(!queue.isEmpty()) {
         result[index++] = queue.poll();
     }   
    return result;
    }
}