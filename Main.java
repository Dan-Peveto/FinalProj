/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        RBT bst = new RBT();
        bst.insert(55);
        bst.insert(40);
        bst.insert(65);
        bst.insert(60);
        bst.insert(75);
        bst.insert(57);
        bst.printTree();
    }
}