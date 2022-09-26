class Solution {
   public boolean equationsPossible(String[] equations) {
        
        List<Character>[] graph = new LinkedList[26];
        List<String> not = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            graph[i] = new LinkedList<>();
        }
        
        for (String str: equations) {
            if (str.charAt(1) == '=') {
                graph[str.charAt(0) - 'a'].add(str.charAt(3));
                graph[str.charAt(3) - 'a'].add(str.charAt(0));
            } else {
                not.add(str);
            }
        }
        
        for (String s: not) {
            if (dfs(graph, s.charAt(0), s.charAt(3))) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(List<Character>[] graph, Character start, Character target) {
        
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        stack.add(start);
        Character ch;
        
        while (!stack.isEmpty()) {
            
            ch = stack.pop();
            visited[ch - 'a'] = true;
            
            if (ch == target) {
                return true;
            }
            
            Iterator<Character> it = graph[ch - 'a'].iterator();
            while (it.hasNext()) {
                
                Character chr = it.next();
                if (!visited[chr - 'a']) {
                    stack.push(chr);
                }
            }
        }
        
        return false;
    }
}