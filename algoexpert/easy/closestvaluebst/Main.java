package io.algoexpert.easy.closestvaluebst;

public class Main {
    class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value){
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST root, int target) {
        return findClosestValueInBst(root,target, root);
    }

    public static int findClosestValueInBst(BST root, int target, BST closestNode) {
        if(root == null)
            return closestNode.value;

        if(Math.abs(root.value - target) < Math.abs(closestNode.value - target))
            closestNode = root;

        if(target > root.value)
            return findClosestValueInBst(root.right, target, closestNode);
        else
            return findClosestValueInBst(root.left, target, closestNode);

    }

    public static void main(String[] args) {

    }
}
