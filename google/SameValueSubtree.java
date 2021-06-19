public class SameValueSubtree {
    private static int count = 0;
    private static class BinaryTreeNode{
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public int value;

        public BinaryTreeNode(int value){
            this.value = value;
        }
    }

    public static boolean sameSubtreeValue(BinaryTreeNode root){
        if(root.left == null && root.right == null)
            return true;

        boolean sameLeft = true;
        if(root.left != null){
            sameLeft = sameSubtreeValue(root.left);
        }

        boolean sameRight = true;
        if(root.right != null){
            sameRight = sameSubtreeValue(root.right);
        }


        boolean flag = true;
        if(sameLeft && sameRight){
            int mutualValue = root.value;
            if(root.left != null && root.left.value != mutualValue){
                System.out.println(root.left.value);
                count++;
                flag = false;
            }
            if(root.right != null && root.right.value != mutualValue){
                System.out.println(root.right.value);
                count++;
                flag = false;
            }
        }else{
            flag =false;
        }

        return flag;
    }

    public static void solve(BinaryTreeNode root){
        count = 0;

        sameSubtreeValue(root);
    }
}
