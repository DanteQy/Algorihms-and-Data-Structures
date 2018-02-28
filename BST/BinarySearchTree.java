 /**
 *
 * @author Dante
 */
public class BinarySearchTree {

    public static Node root;
    
    //Constructor
    public BinarySearchTree() {
        this.root = null;
    }
    
    /*
    Complexity: O(n) because it visit every node once
    */
    public boolean treeSearch(int id) {
        
        //Parte sempre dalla radice
        Node current = root;
        while (current != null) {   //procede finchè ci sono nodi
            if (current.key == id) {  //se è uguale all'id univoco ha finito
                return true;
            } else if (current.key > id) {  //se è maggiore dell'id va a dx
                current = current.left;
            } else {
                current = current.right;  //altrimenti a sx
            }
        }
        return false;  //se non ritorna true ha fallito la ricerca
    }
 
    
    // This method mainly calls insertRec()
    void insert(int key) {
       root = insertUtil(root, key);
    }
    
    /*Function to insert the node in a specific case
    Since it's not static the root will not be changed
    */
    Node insertUtil(Node root, int value) {
        
        //when it gets to a leaf.
        if (root == null) {
            root = new Node(value);
            return root;
        }
        
        //go to the left
        if (value < root.key)   root.left = insertUtil(root.left, value);
        //go to the right
        else if (value > root.key) root.right = insertUtil(root.right, value);
 
        return root;
    }

    public void displayInOrder(Node root) {
        if (root != null) {
            displayInOrder(root.left);
            System.out.print(" " + root.key);
            displayInOrder(root.right);
        }
    }
     

    public static void main(String arg[]) {
        BinarySearchTree b = new BinarySearchTree();
        int value = 5;
        b.insert(1);
        b.insert(2);
        b.insert(3);
        b.insert(4);
        b.insert(5);
        b.insert(6);
        b.insert(7);
        b.insert(8);
        b.insert(9);
        b.insert(11);
        b.insert(15);
        b.insert(16);
        System.out.println("Tree : ");
        b.displayInOrder(b.root);  
        System.out.println("1nSearch "+value+": " + b.treeSearch(value));  
    }
}
