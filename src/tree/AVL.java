package tree;

import java.util.Scanner;

public class AVL {
    private class Node{
        int value;
        Node left;
        Node right;
        int height;
        public Node(int value){
            this.value = value;
        }
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }
    private Node root;


    public void populateAVL(int[] nums){
//        root = new Node(nums[0]);
        for (int i = 0; i < nums.length-1; i++) {
            insert(nums[i]);
        }
    }

    public void populateAVLSorted(int[] nums){
        populateAVLSorted(nums,0,nums.length);
    }

    private void populateAVLSorted(int[] nums,int start,int end){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        insert(nums[mid]);
        populateAVLSorted(nums,start,mid);
        populateAVLSorted(nums,mid+1,end);
    }

    private void populateAVL(Node node, int value){
        if(node == null){
            return;
        }
        if(value < node.value){
            if(node.left == null) node.left=new Node(value);
            else populateAVL(node.left,value);
        }else{
            if(node.right == null) node.right = new Node(value);
            else populateAVL(node.right,value);
        }

        node.height = Math.max(height(node.left)+1,height(node.right)+1);

    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        if(height(node.left) - height(node.right) > 1){
            //left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                //left-left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                //left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left) - height(node.right) < -1){
            //right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                //right-right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                //right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;
        c.right = p;
        p.left = t;
        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;

        return p;
    }



    public void display(){
        display(root,0);
    }
    private void display(Node node, int level){
        if(node == null){
            return;
        }

        display(node.right,level+1);
        if(level != 0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->"+node.value+'('+node.height+')');
        }else{
            System.out.println(node.value+"("+node.height+")");
        }
        display(node.left,level+1);
    }

    public boolean balanced() {
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null) return true;

        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left) && balanced(node.right);
    }

    public void preOrder(){
        preOrderDisplay(root);
    }
    private void preOrderDisplay(Node node){
        if(node == null) return;

        System.out.print(node.value+",");
        preOrderDisplay(node.left);
        preOrderDisplay(node.right);
    }

    public void inOrder(){
        inOrderDisplay(root);
    }
    private void inOrderDisplay(Node node){
        if(node == null) return;

        inOrderDisplay(node.left);
        System.out.print(node.value+",");
        inOrderDisplay(node.right);
    }

    public void postOrder(){
        postOrderDisplay(root);
    }
    private void postOrderDisplay(Node node){
        if(node == null) return;

        postOrderDisplay(node.left);
        postOrderDisplay(node.right);
        System.out.print(node.value+",");

    }
}
