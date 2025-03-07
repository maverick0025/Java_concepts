package bt;

import java.util.Scanner;

class BinaryTree {

    public BinaryTree() {
    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root node value: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node){

        System.out.println("Do you want to enter the left node of : "+ node.value);
        boolean left_b = scanner.nextBoolean();
        if(left_b){
            System.out.println("Enter the left node value of: "+ node.value);
            int left_value = scanner.nextInt();
            node.left = new Node(left_value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter the right node of: "+ node.value);
        boolean right_b = scanner.nextBoolean();
        if(right_b){
            System.out.println("Enter the right node value of: "+ node.value);
            int right_value = scanner.nextInt();
            node.right = new Node(right_value);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(this.root, "");
    }

    private void display(Node node, String indent){
        if(node == null){
            return;
        }

        System.out.println(node.value);
        display(node.left, indent + " \t");
        display(node.right, indent + " \t");
    }

    public void preorder(){
        preorder(root);
    }
    private void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(){
        preorder(root);
    }
    private void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.println(node.value + " ");
        inorder(node.right);
    }

    public void postorder(){
        postorder(root);
    }
    private void postorder(Node node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value + " ");

    }

}
