public class RBT {
    // Fields
    private Node root; // Create root node
    private Node TNULL; // presents the NIL leaves
    // Methods

    // Preorder Method
    private void preOrderHelper(Node node) 
    {
        if (node != TNULL) // If not null keep going
            {   preOrderHelper(node.left);
                preOrderHelper(node.right);
            }
    }
    // insertion / Print -- Insert Print
    // balance after insert / rotate left / rotate right -- Trevor
    // get height / delete -- Dan

    // CTOR
}
