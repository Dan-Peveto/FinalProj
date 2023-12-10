
public class RBT {
    private Node root; // create root node
    private Node TNULL; // create leafs that are null
  
   
  
   
  
    public void insert(int newNode) 
      {
        Node node = new Node(); // create new node
        node.value = newNode; // populate node.value with a value
        //node.parent = null;
        node.left = TNULL; // point to nil leaves
        node.right = TNULL;
        node.color = 1; // newNodeis red
    
        Node prev = null; // keep track with a previous node
        Node finger = this.root; // point finger node to the rrot
    
        while (finger != TNULL) { // if finger is not 
          prev = finger; // start with prev and cur at same point
          if (node.value < finger.value)  // if node is less than (or left to) finger
          {
            finger = finger.left; // move finger left
          } else // otherwise 
          {
            finger = finger.right; //over right
          }
        }
    
        node.parent = prev; // node points to parent
        if (prev == null) // if node is the root ie parent is null
        {
          root = node; // the note is the root
        } else if (node.value < prev.value) // if node is not the root is it less than ie left of
        {
          prev.left = node; // node left
        } else // otherwise
        {
          prev.right = node; // move node right
        }
        // at this point the node has found where it should be inserted
        if (node.parent == null) // if node is the root
        {
          node.color = 0; // node is black
          return; // exit the loop
        }
        if (node.parent.parent == null) // if the parent is the root
        {
          return; // exit the loop
        }
    
        fixInsert(node); // call fixInsert and pass input node
      }
  
    // Balance the node after insertion
    private void fixInsert(Node newNode) 
    {
      Node uncle; // create uncle variable
      while (newNode.parent.color == 1) // while parent node is red
      {
        if (newNode.parent == newNode.parent.parent.right) // if newNode parent is the right node of its parent
        {
          uncle = newNode.parent.parent.left; // then the uncle is to the left
          if (newNode.color == 1) // if the newNode is red
          {
            newNode.color = 0; // change to black
            newNode.parent.color = 0; // change parent color to black
            newNode.parent.parent.color = 1; // change grandparent color to red
            newNode = newNode.parent.parent; // insert the newNode as the grandparent...And this is how you can be your own grandpa
          } else // otherwise
          {
            if (newNode == newNode.parent.left) // if newNode is the left child
            {
              newNode = newNode.parent; //Insert newNode as the parent
              rightRotate(newNode); // call rotate right function
            }
            newNode.parent.color = 0; // parent black
            newNode.parent.parent.color = 1; // grandparent become red
            leftRotate(newNode.parent.parent); // rotate left with grandparent passed
          }
        } else // otherwise
        {
          uncle = newNode.parent.parent.right; // uncle is the parent node
  
          if (newNode.color == 1) // if newNode is red 
          {
            uncle.color = 0; // uncle becomes black
            newNode.parent.color = 0; //parent becomes black
            newNode.parent.parent.color = 1; // grandparent becomes red
            newNode = newNode.parent.parent; // newNode become grandparent
          } else // otherwise (newNode is black)
          {
            if (newNode == newNode.parent.right) //if newNode is to the right of parent
            {
              newNode = newNode.parent; //newNode becomes the parent
              leftRotate(newNode); // rotate with newNode
            }
            newNode.parent.color = 0;//parent become black
            newNode.parent.parent.color = 1; // grandparent becomes red
            rightRotate(newNode.parent.parent); // rotate right from grandparent
          }
        }
        if (newNode == root) // if newNode is root
        {
          break; // break root
        }
      }
      root.color = 0; // root is black
    }
  
    public void printTree() 
    {
      printHelper(this.root, "", true);
    }
    private void printHelper(Node root, String indent, boolean last) 
    {
      if (root != TNULL) 
      {
        System.out.print(indent);
        if (last) {
          System.out.print("R----");
          indent += "   ";
        } else 
        {
          System.out.print("L----");
          indent += "|  ";
        }
  
        String sColor = root.color == 1 ? "RED" : "BLACK";
        System.out.println(root.value + "(" + sColor + ")");
        printHelper(root.left, indent, false);
        printHelper(root.right, indent, true);
      }
    }
  
    public void leftRotate(Node node) 
    {
      Node sibling = node.right; // move node into sibling spot
      node.right = sibling.left;// swap connections
      if (sibling.left != TNULL) // if sibling left is nil leaf
      {
        sibling.left.parent = node; // move node
      }
      sibling.parent = node.parent;
      if (node.parent == null) // if node iis root
      {
        this.root = sibling; // sibling becomes root
      } else if (node == node.parent.left) // otherwise if node is left child
      {
        node.parent.left = sibling; // swap
      } else // otherwise 
      {
        node.parent.right = sibling; // swap
      }
      sibling.left = node; //swap
      node.parent = sibling; //swap
    }
  
    public void rightRotate(Node node) 
    {
      Node sibling = node.left; // create sibling node
      node.left = sibling.right; // swap
      if (sibling.right != TNULL) // if sibling to the right is not NIL leaf
      {
        sibling.right.parent = node; // swap
      }
      sibling.parent = node.parent; // swap
      if (node.parent == null) // if node is not root
      {
        root = sibling; // sibling becomes root
      } else if (node == node.parent.right) // otherwise if node is right child
      {
        node.parent.right = sibling; // swap
      } else // otherwise node is left child
      {
        node.parent.left = sibling; // swap
      }
      sibling.right = node; //swap
      node.parent = sibling; // swap
    }
    
    public RBT() {
        TNULL = new Node();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }
}
