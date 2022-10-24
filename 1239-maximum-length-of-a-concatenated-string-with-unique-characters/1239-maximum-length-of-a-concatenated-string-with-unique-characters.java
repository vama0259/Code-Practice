class Solution {
     public int maxLength(List<String> arr) {
	
        int n = arr.size();
		
        int [] result = new int[1];
        
        maxLengthUnique(arr,result,0,"");
		
        return result[0];
    }
    
    private void maxLengthUnique(List<String> arr,int []result,
                                 int index,String current){
								 
		int i = 0, n = arr.size();
		
		// We use queue to store all the combinations possible!
        Queue<String> q = new LinkedList<>();
        q.add("");
		
		//Loop for all the strings in array.
        while(i < n){
            int size = q.size();
            
			//Loop till all the elements in Queue are appended with "" and the string 'str'
            for(int loop = 0;loop < size; loop++){
                String temp = q.poll();    // temp = "" 
                String dontConsider = temp; // dontConsider = ""
                String consider = temp + arr.get(i); // consider = "un" --> Aboe 3 steps Repeated till the last element.
				
				// Function call to calculate the unique characters
                if(uniqueCharacters(dontConsider) > result[0]){
                    result[0] = dontConsider.length();
                }
				// Function call to calculate the unique characters
                if(uniqueCharacters(consider) > result[0]){
                    result[0] = consider.length();
                }
				// Adding the new strings to our queue again.
                q.add(dontConsider);
                q.add(consider);
            }
            i++;
        }
        
    }
    
    private int uniqueCharacters(String string){
        char[] alpha = new char[26];
        
        for(char character : string.toCharArray())
            if(alpha[character - 'a']++ > 0) 
                return -1;
        
        return string.length();
    } 
}