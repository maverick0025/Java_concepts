package segt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class SegmentTree {

    private static class Node{

       private int data;
       private int leftInterval;
       private int rightInterval;
       private Node left;
       private Node right;

        public Node(int leftInterval, int rightInterval) {
            this.leftInterval = leftInterval;
            this.rightInterval = rightInterval;
        }
    }

    public SegmentTree(int[] arr) {
        this.root = populate(0, arr.length - 1, arr);
    }

    private Node root;

//    public void populate(int[] arr){
//        this.root = populate(0, arr.length-1, arr);
//    }

    private Node populate(int l, int r, int[] array){
        if(l == r){
            //leaf node
            Node leaf = new Node(l, r);
            leaf.data = array[l];
            return leaf;
        }

        Node node = new Node(l, r);

        int mid = ( l + r ) / 2;

        node.left = populate(l, mid, array);
        node.right = populate(mid+1, r, array);
        node.data = node.left.data + node.right.data;

        return node;
    }

    public void display(){
        display(this.root);
    }
ArrayList<Integer> in = new ArrayList<>();
    private void display(Node node){

        String str = "";
        if(node.left != null){
            str = str + "Interval =    [ "+ node.left.leftInterval + " - "+ node.left.rightInterval+ " ] and it's data: "+ node.left.data + " => ";
        }else{
            str = str + "No left child";
        }

        if(node.right != null){
            str = str + "Interval =    [ "+ node.right.leftInterval + " - "+ node.right.rightInterval+ " ] and it's data: "+ node.right.data + " => ";
        }else{
            str = str + "No right child";
        }
        System.out.println(str + '\n');

        if(node.left != null){
            display(node.left);
        }
        if(node.right != null) {
            display(node.right);
        }
    }

    public int query(int qsi, int qei){

        return query(this.root,  qsi,  qei);
    }

    private int query(Node node, int qsi, int qei){

        // same interval and a part of it
        if(node.leftInterval >= qsi && node.rightInterval <= qei){
            return node.data;
        }

        //out of bounds of an interval
       else if(node.leftInterval > qsi || node.rightInterval < qsi){
            return 0;
        }
       else{
           //overlapping
          return this.query(node.left, qsi, qei)+ query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value){
        this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int index, int value){

        if(node.leftInterval >= index && node.rightInterval<= index){
            if(index == node.leftInterval && index == node.rightInterval){
                node.data = value;
                return node.data;
            }else{
            node.data = update(node.left, index, value) + update(node.right, index,value);
            return node.data;
            }
        }

        return node.data;
    }

}
