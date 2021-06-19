package io.algoexpert.easy.branchsum;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> result ;

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void branchTraverse(BinaryTree node, int sum){
        if(node.left != null)
            branchTraverse(node.left, sum + node.value);

        if(node.right != null)
            branchTraverse(node.right, sum + node.value);

        if(node.left == null && node.right == null)
            result.add(sum + node.value);
    }

    public static List<Integer> branchSums(BinaryTree root) {
        result= new ArrayList<Integer>();
        branchTraverse(root, 0);

        return result;
    }
}
