package bst;

public class BST {

    private static class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }
        public int getValue(Node node){
            if(node == null){
                return -1 ;
            }
            return node.value;
        }

        public int getHeight(Node node){
            if(node == null){
                return -1;
            }
            return node.height;
        }

    }

    public BST(){

    }


    private Node root;


    public void insert(int value){
        if(this.root == null){
             this.root = new Node(value);
            return;
        }
        insert(root, value );
    }

    private Node insert(Node node, int value){

        if(node == null){
            Node node1 = new Node(value);
            return node1;
        }
        if(node.value > value){
            //insert to the left
            node.left = insert(node.left, value);
        }
        if(node.value < value){
            node.right = insert(node.right, value);
        }
        node.height = Math.max( node.getHeight(node.left), node.getHeight(node.right) ) +1;

        return node;
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

        System.out.println(root.getValue(root));
        display(root, "Root Node: ");
    }

    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "left child of "+ node.value + " is: ");
        display(node.right, "right child of "+ node.value + " is: ");
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }

}
