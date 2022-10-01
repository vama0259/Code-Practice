class Solution {
    public int numDecodings(String s) {
        
        int[] dp = new int[s.length()];
        
        Arrays.fill(dp,-1);
        
        return recursion(s,0,dp);

    }
    
    public int recursion(String s, int index, int[] dp){
        if(index==s.length()){
            return 1;
        }
        
        if(s.charAt(index)=='0')
            return 0;
        
        if(dp[index]!=-1)
            return dp[index];
        
        int o1 = recursion(s,index+1,dp);
        int o2 = 0;
        if(index+1<s.length()){
            int val = (s.charAt(index)-'0')*10 + (s.charAt(index+1)-'0');
            if(val<=26){
                o2 = recursion(s,index+2,dp);
            }
        }
        
        dp[index] = o1 + o2;
        
        return dp[index];
    }
}