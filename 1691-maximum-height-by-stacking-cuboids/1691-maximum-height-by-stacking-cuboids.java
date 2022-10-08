class Solution {
    public int maxHeight(int[][] arr) {
        for(int[]a:arr)Arrays.sort(a);
        
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                if(a[0]!=b[0])return a[0]-b[0];
                else
                if(a[1]!=b[1])return a[1]-b[1];
                return a[2]-b[2];
            }
        });
        
        int ans=0;
        int[]dp=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            dp[i]=arr[i][2];
            for(int j=0;j<i;j++){
                if(arr[i][0]>=arr[j][0]&&arr[i][1]>=arr[j][1]&&arr[i][2]>=arr[j][2]){
                    dp[i]=Math.max(dp[i],arr[i][2]+dp[j]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        
        return ans;
        
    }
}