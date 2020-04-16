class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    // created a new node with empty child pointers
    myValue = inValue;//new node with left and right being null
    right = null;
    left = null;
  }
  
  myBinarySearchTreeNode(int[] A){
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.
    myValue = A[0];
    for(int i = 1; i < A.length; i++){//i = 1 to skip the root number A[0]
      this.insert(A[i]);
    }
  }
  
  public void insert(int inValue){
    // This method takes a new integer as input and decides
    // if it should be place:
    //    * as the left child,
    //    * as the right child,
    //    * in the left subtree,
    //    * or in the right subtree.
    // If the value already exists in the tree, no action is taken.

    if(inValue == this.myValue){//this will prevent duplicates from being added to the tree
      System.out.println("The integer " + inValue + " already exists in the tree");//error message
    }

    if(inValue > this.myValue){//goes to the right of the tree
      if(right == null){//if right node is empty
        right = new myBinarySearchTreeNode(inValue);
      }
      else{
        right.insert(inValue);//recursive by inserting on the right side
      }
    }

    else{//goes to the left since inValue is < this.myValue
      if(left == null){//if left node is empty
        left = new myBinarySearchTreeNode(inValue);//insert inValue in the given node left node
      }
      else{
        left.insert(inValue);//recursive by inserting on left side
      }
    }
    
  }
  
  public int height(){
     // This method recursively calculates the height of the entire (sub)tree.
     // This method will take O(n) time
    int rightH = 0;//right height
    int leftH = 0;//left height
    int height;// be used as overall height
    if(left != null){
      leftH = 1 + left.height();//recursive call
    }
    if(right != null){
      rightH = 1 + right.height();//recursive call
    }
    //find greatest height to return as overall height
    if(rightH > leftH) {
      height = rightH;//return height of right subtree
    }
    else{
      height = leftH;//return height of left subtree
    }
    return height;//return value
  }
  
  public int depth(int search){
     // This method recursively calculates the depth of a given search value. 
     // If the given value is not in the tree, this method returns -1. 
     // Note that if the tree is a proper BST, this method should complete in O(log n) time.
     // Additionally, remember that the depth is the number of nodes on the path from a node to the root 
     // (i.e. the number of the recursive calls).
    if(search < this.myValue){
      return 1 + left.depth(search);//recursively search left
    }
    if(search > this.myValue){
      return 1 + right.depth(search);//recursively search right
    }
    if(search == this.myValue){//if search value is found
      return 0;//return depth value
    }
      return -1;//if value is not found in tree

  }
  public int size(){
    int sum = 0;//first element or root of tree
    //recursive
    if(left != null){
      sum += left.size();//recursive call on left side
    }
    if(right != null){
      sum += right.size();//recursive call on right side
    }
    print();
    return sum + 1;
  }
  
  // Utility function included so you can debug your solution. 
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
} 
