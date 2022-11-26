class Solution {
    
    class Job
    {
        int start;
        int end;
        int profit;
        
        public Job(int start, int end , int profit)
        {
            this.start= start;
            this.end= end;
            this.profit= profit;
        }
    }
    
    public int findNonConflicting(int index, Job jobs[])
    {
        // returns profit of the last non conflicting job
        // find jobs[i].profit for jobs[i].end< end
        
        int low=0;
        int high=index-1;
        
        int endTime= jobs[index].start;
        
        while (low<=high)
        {
            int mid= (low+high)/2;
            if (jobs[mid].end<= endTime)
            {   
                if (jobs[mid+1].end> endTime)
                return jobs[mid].profit;
            
                else
                low= mid+1;
            }
            else 
                high= mid-1;        
        }
        
            return 0;     
        
        
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job jobs[]= new Job[startTime.length+1];
        jobs[0]= new Job(0,0,0);
        
       for (int i=0; i<startTime.length; i++)
            jobs[i+1]= new Job(startTime[i], endTime[i], profit[i]);
        
       Arrays.sort(jobs, (o1, o2)->(o1.end-o2.end)); // Ascending order  
        
        for (int i=1; i<jobs.length; i++){
            // For every job we have a choice to add or discard: Ensure if we add,then next addition should be non-conflicting, if we discard, profit remains unchanged: Recursion
            
            // Iterative solution, using a dp approach, bottom up
            // If Add-> profit= currval+ maximumn profit for last non-conflicting [We go bottom up]
            // If Discard-> profit= previous (which is also max profit)
            
            int include= jobs[i].profit + findNonConflicting(i, jobs); // Last Non Conflicting, e1< e2 curr
            int exclude= jobs[i-1].profit;
            
            jobs[i].profit= Math.max(include, exclude);
            
        }
        
        return jobs[startTime.length].profit;
        
    }
}