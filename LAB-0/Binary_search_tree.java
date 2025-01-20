// Binary Search Tree implementation in Java

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinarySearchTree {
    private Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Method to add a value to the tree
    public void add(int value) {
        root = addRecursive(root, value);
    }

    // Recursive method for adding a value
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    // Method to check if a value exists in the tree
    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    // Recursive method to check if a value exists
    private boolean containsRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value 
            ? containsRecursive(current.left, value) 
            : containsRecursive(current.right, value);
    }

    // Method to perform in-order traversal
    public void traverseInOrder() {
        traverseInOrderRecursive(root);
        System.out.println();
    }

    // Recursive method for in-order traversal
    private void traverseInOrderRecursive(Node node) {
        if (node != null) {
            traverseInOrderRecursive(node.left);
            System.out.print(node.value + " ");
            traverseInOrderRecursive(node.right);
        }
    }
}

// Main class to demonstrate Binary Search Tree
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Adding elements to the BST
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);
        bst.add(60);
        bst.add(80);

        // In-order traversal
        System.out.println("In-order Traversal:");
        bst.traverseInOrder();

        // Search for elements
        int search1 = 40;
        int search2 = 90;
        System.out.println("Contains " + search1 + ": " + bst.contains(search1));
        System.out.println("Contains " + search2 + ": " + bst.contains(search2));
    }
}
