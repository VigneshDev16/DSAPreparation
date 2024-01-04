package tree;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.populate(scanner);
//        binaryTree.display();

        int[] nums = new int[]{5,2,1,6,3,8,7,4,9,0};
        BST bst = new BST();
//        bst.populateBST(nums);
        Arrays.sort(nums);
        bst.populateBSTSorted(nums);
        bst.display();
        System.out.println();
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
    }
}
