class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() < 2) return "";
        
        char[] arr = palindrome.toCharArray();
        
        int condition = -1; // this is to avoid the case when checking odd length palindrome: example: "aba"
        
        if (arr.length % 2 != 0) {
            condition = arr.length / 2;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (i != condition && arr[i] != 'a') {
                arr[i] = 'a';
                break;
            }
            if (i == arr.length - 1) {
                arr[i] = 'b';
            }
        }
        
        return String.valueOf(arr); 
    }
}