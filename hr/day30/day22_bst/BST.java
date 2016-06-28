	public static int getHeight(Node root){
      if (root == null) {
          return -1;
      } else if (root.left == null && root.right == null) {
          return 0;
      } else {
          int leftHeight = 1 + getHeight(root.left);
          int rightHeight = 1 + getHeight(root.right);
          
          return leftHeight > rightHeight ? leftHeight : rightHeight;
      }
    }

