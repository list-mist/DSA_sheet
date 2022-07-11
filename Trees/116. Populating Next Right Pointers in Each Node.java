class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        dfs(root,null);
        return root;
    }
    Node bfs(Node root){
        HashMap<Integer,Node> rightMap = new HashMap<>();
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            while(size-- > 0){
            Node rp = q.poll();
            if(rightMap.containsKey(level)){
                map.put(rp, rightMap.get(level));
                rp.next = rightMap.get(level);
            }
            else{
                map.put(rp, null);
            }
            rightMap.put(level, rp);
            if(rp.right != null){
                q.add(rp.right);
            }        
            if(rp.left != null){
                q.add(rp.left);
            }
        }
        level++; 
        }
     
        return root;
    }
    Node bfsNode(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int children = 0;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            children = (int)Math.pow(2, level);
        
            while(size-- > 0){
                Node rp = q.poll();
                
                if(children != 1 && q.isEmpty() == false){
                    rp.next = q.peek();
                    children -= 1;
                }
                if(rp.left != null) q.add(rp.left);
                if(rp.right != null) q.add(rp.right);
            }
            level++;
        }
        return root;
    }
    void dfs(Node root, Node prev){
        if(root == null) return ;
        root.next = prev;
        dfs(root.left, root.right);
        dfs(root.right , root.next == null ? null : root.next.left);
    }
}
