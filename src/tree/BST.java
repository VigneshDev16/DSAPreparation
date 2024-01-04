package tree;

import java.util.Scanner;

public class BST {
    
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

    public void populateBST(Scanner scanner){
        System.out.println("Enter the value of Root: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populateBST(scanner,root);
    }
    public void populateBST(int[] nums){
        root = new Node(nums[0]);
        for (int i = 1; i < nums.length-1; i++) {
            populateBST(root,nums[i]);
        }
    }

    public void populateBSTSorted(int[] nums){
        populateBSTSorted(nums,0,nums.length);
    }

    private void populateBSTSorted(int[] nums,int start,int end){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        insert(nums[mid]);
        populateBSTSorted(nums,start,mid);
        populateBSTSorted(nums,mid+1,end);
    }

    private void populateBST(Scanner scanner, Node node) {
        System.out.println("Do you want to enter a new value : ");
        boolean res = scanner.nextBoolean();
        if(res){
            System.out.println("Please enter the value : ");
            int value = scanner.nextInt();
            populateBST(node,value);
            populateBST(scanner,root);
        }
        root.height = Math.max(height(root.left)+1,height(root.right)+1);
    }
    private void populateBST(Node node, int value){
        if(node == null){
            return;
        }
        if(value < node.value){
            if(node.left == null) node.left=new Node(value);
            else populateBST(node.left,value);
        }else{
            if(node.right == null) node.right = new Node(value);
            else populateBST(node.right,value);
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
        return node;
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
