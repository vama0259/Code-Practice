class Solution {
    Numeral[] pair = {
        new Numeral("M", 1000),
        new Numeral("CM", 900),
        new Numeral("D", 500),
        new Numeral("CD", 400),
        new Numeral("C", 100),
        new Numeral("XC", 90),
        new Numeral("L", 50),
        new Numeral("XL", 40),
        new Numeral("X", 10),
        new Numeral("IX", 9),
        new Numeral("V", 5),
        new Numeral("IV", 4),
        new Numeral("I", 1)     
    };
    public String intToRoman(int num) {
        String result = "";
        for(Numeral numa : pair){
            int noOfTimes = num / numa.number;
            if(noOfTimes != 0){
                result += numa.character.repeat(noOfTimes);
            }
            num = num % numa.number;
        }
            
        return result;
    }
    
    class Numeral{
        int number;
        String character;
        Numeral(String character, int number){
            this.number = number;
            this.character = character;
        }
    }
}