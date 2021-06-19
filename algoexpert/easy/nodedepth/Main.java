package io.algoexpert.easy.nodedepth;

public class Main {
    public static int sum;

    public static void nodeDepths(BinaryTree root, int currentDepth){
        if(root.left != null){
            nodeDepths(root.left, currentDepth + 1);
            sum+= currentDepth + 1;
        }

        if(root.right != null){
            sum+= currentDepth + 1;
            nodeDepths(root.right, currentDepth + 1);
        }
    }

    public static int nodeDepths(BinaryTree root) {
        sum = 0;
        nodeDepths(root, 0);

        return sum;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
