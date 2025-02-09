import java.io.*;
import java.util.*;

public class avl_tree {
    class Node {
        int item, height;
        Node left, right;

        Node(int d) {
            item = d;
            height = 1;
        }
    }

    Node root;

    int height(Node N) {
        return (N == null) ? 0 : N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    int getBalanceFactor(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    Node insertNode(Node node, int item) {
        if (node == null) return new Node(item);
        if (item < node.item)
            node.left = insertNode(node.left, item);
        else if (item > node.item)
            node.right = insertNode(node.right, item);
        else
            return node;
        node.height = 1 + max(height(node.left), height(node.right));
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1 && item < node.left.item) return rightRotate(node);
        if (balanceFactor < -1 && item > node.right.item) return leftRotate(node);
        if (balanceFactor > 1 && item > node.left.item) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor < -1 && item < node.right.item) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    Node nodeWithMinimumValue(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    Node deleteNode(Node root, int item) {
        if (root == null) return root;
        if (item < root.item)
            root.left = deleteNode(root.left, item);
        else if (item > root.item)
            root.right = deleteNode(root.right, item);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = nodeWithMinimumValue(root.right);
                root.item = temp.item;
                root.right = deleteNode(root.right, temp.item);
            }
        }
        if (root == null) return root;
        root.height = max(height(root.left), height(root.right)) + 1;
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1 && getBalanceFactor(root.left) >= 0) return rightRotate(root);
        if (balanceFactor > 1 && getBalanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balanceFactor < -1 && getBalanceFactor(root.right) <= 0) return leftRotate(root);
        if (balanceFactor < -1 && getBalanceFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    void inOrder(Node node, BufferedWriter writer) throws IOException {
        if (node != null) {
            inOrder(node.left, writer);
            writer.write(node.item + " ");
            inOrder(node.right, writer);
        }
    }

    void printTree(Node currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.item);
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }
    }

    public static void main(String[] args) {
        avl_tree tree = new avl_tree();
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split("\\s+");
                for (String num : numbers) {
                    tree.root = tree.insertNode(tree.root, Integer.parseInt(num));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        tree.printTree(tree.root, "", true);
        System.out.println("AVL Tree Before Deletion:");
        tree.printTree(tree.root, "", true);
        tree.root = tree.deleteNode(tree.root, 13);
        System.out.println("\nAVL Tree After Deletion:");
        tree.printTree(tree.root, "", true);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            tree.inOrder(tree.root, writer);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        System.out.println("\nIn-order traversal saved to " + outputFile);
    }
}
