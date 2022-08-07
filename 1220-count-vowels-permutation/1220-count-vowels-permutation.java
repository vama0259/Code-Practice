class Solution {
    public int countVowelPermutation(int n) {
        int modulo = (int)(Math.pow(10, 9) + 7);
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        
        for(int k = 2; k <= n; k++) {
            int newa = ((e + i)%modulo + u)%modulo;
            int newe = (a + i)%modulo;
            int newi = (e + o)%modulo;
            int newo = i;
            int newu = (i + o)%modulo;
            
            a = newa;
            e = newe;
            i = newi;
            o = newo;
            u = newu;
        }
        return (((((a + e)%modulo + i)%modulo) + o)%modulo + u)%modulo;
    }
}