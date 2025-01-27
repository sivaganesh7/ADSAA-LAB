import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root = null;

    public void insert(int item) {
        root = insertRec(root, item);
    }

    private Node insertRec(Node root, int item) {
        if (root == null) {
            return new Node(item);
        }
        if (item < root.data) {
            root.left = insertRec(root.left, item);
        } else if (item > root.data) {
            root.right = insertRec(root.right, item);
        }
        return root;
    }

    // Print the tree in a structured format
    public void printTree() {
        printTreeRec(root, "", true);
    }

    private void printTreeRec(Node node, String prefix, boolean isRight) {
        if (node != null) {
            System.out.println(prefix + (isRight ? "R----" : "L----") + node.data);
            printTreeRec(node.left, prefix + (isRight ? "   " : "|  "), false);
            printTreeRec(node.right, prefix + (isRight ? "   " : "|  "), true);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BST bst = new BST();
        String choice;

        // Input elements into the BST
        do {
            System.out.print("Enter the Element: ");
            int item = Integer.parseInt(reader.readLine());
            bst.insert(item);

            System.out.print("Press 'y' to continue: ");
            choice = reader.readLine();
        } while (choice.equalsIgnoreCase("y"));

        // Display the structured tree
        System.out.println("Tree Structure:");
        bst.printTree();
    }
}
