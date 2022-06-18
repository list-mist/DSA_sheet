class Node{
    Node[] links;
    boolean flag;
    
    Node(){
        links = new Node[26];
        flag = false;
    }
    void put(char ch, Node newNode){
        links[ch-'a'] = newNode;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    boolean containsKey(char ch){
        if(links[ch-'a'] != null) return true;
        return false;
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd(){
        return flag;
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
    
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node = node.get(ch);
        }
       
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        return dfs(word,node,0);
    }
    boolean dfs(String word, Node node,int idx){
        if(node == null) return false;
        if(idx == word.length()) return node.flag;
        
        
        boolean ans = false;
        if(word.charAt(idx) != '.'){
            ans =  dfs(word,node.get(word.charAt(idx)), idx + 1);
        }else{
            for(int i = 0; i < 26; i++){
                    char ch = (char) (i + 97);
                    ans = ans || dfs(word, node.get(ch), idx + 1);
            }
        }
        return ans;
    }
}
