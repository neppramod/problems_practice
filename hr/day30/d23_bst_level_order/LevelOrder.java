static void levelOrder(Node root){
       if (root == null) {
           return;
       }
        
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);
        
       while (!queue.isEmpty()) {
           Node n = queue.poll();
           System.out.print(n.data + " ");
           
           if (n.left != null) {
               queue.add(n.left);               
           }
           
           if (n.right != null) {
               queue.add(n.right);
           }
       }
       System.out.println();
    }
