package avl;

public class AVL {

    private class Node{
        private int value;
        private   Node left;
        private   Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }

    private   Node root;
    public AVL(){

    }

    public int height(){
        return height(root);
    }
    private int height(  Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }
    public void insert(int value){
//        if(this.root == null){
//            this.root = new Node(value);
//            return;
//        }
        root = insert(root, value );
    }

    private   Node insert(  Node node, int value){

        if(node == null){
            node = new Node(value);
            return node;
        }
        if(node.value > value){
            node.left = insert(node.left, value);
        }
        if(node.value < value){
            node.right = insert(node.right, value);
        }
        node.height = Math.max( height(node.left), height(node.right) ) +1;

        return rotate(node);
    }

    private Node rotate(Node node){
        //left affinity
        if(height(node.left) - height(node.right) > 1){

            if(height(node.left.left) - height(node.left.right) > 0 )   {
               // left left case
                return rightRotate(node);
            }
            if(height(node.left.right) - height(node.left.left) > 0 )    {
               // left right case
               node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        //right affinity
        if(height(node.right) - height(node.left) > 1){

            if(height(node.right.right) - height(node.right.left) > 0 )   {
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0 )    {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }
/*
    private Node leftRotate(Node node){

        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        temp.height = Math.max(height(temp.left), height(temp.right )) + 1;
        return temp;
    }
    private Node rightRotate(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        temp.height = Math.max(height(temp.left), height(temp.right )) + 1;
        return temp;
    } */

    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }

    public void insertSorted(int[] nums){
        insertSorted(nums, 0, nums.length);
    }
    private void insertSorted(int[] nums, int start, int end){
        if(start>= end){
            return;
        }
        int mid = (start + end )/2;
        this.insert(nums[mid]);
        insertSorted(nums, start, mid);
        insertSorted(nums, mid+1, end);
    }

    public void display(){

//        System.out.println(root.getValue());
        display(this.root, "Root Node: ");
    }

    private void display(  Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "left child of "+ node.value + " is: ");
        display(node.right, "right child of "+ node.value + " is: ");
    }

    public boolean isEmpty(){
        return root == null;
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(  Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }

}

