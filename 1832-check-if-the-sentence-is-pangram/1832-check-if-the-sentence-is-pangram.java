class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26){return false;}
        HashSet<Character> hs = new HashSet<>();
        for(char c: sentence.toCharArray()){
            hs.add(c);
            if(hs.size() == 26)
                return true;
        }
        
        return hs.size() == 26;
        
    }
}