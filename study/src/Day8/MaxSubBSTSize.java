package Day8;

import javax.sound.sampled.DataLine.Info;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 16:38 2022/1/1
 * @ Description：查找一个二叉树书上最大的搜索二叉树
 * @ Modified By：
 * @Version: $
 */
public class MaxSubBSTSize {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        public boolean isBST; //是不是搜索二叉树
        public int maxSubBstSize; //搜索二叉树的最大值
        public int min; //整棵树最小值
        public int max; //整棵树最大值

        public Info(boolean is, int size, int mi, int ma) {
            isBST = is;
            maxSubBstSize = size;
            min = mi;
            max = ma;
        }
    }

    public static int maxSubBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).maxSubBstSize;
    }


    public static Info process(Node X) {
        if (X == null) {
            return null;
        }

        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);

        boolean isBST; //是不是搜索二叉树
        int maxSubBstSize; //搜索二叉树的最大值
        int min; //整棵树最小值
        int max; //整棵树最大值

        min = X.value;
        max = X.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(min, leftInfo.max);
        }
        if (rightInfo != null) {
            max = Math.min(max, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }

        maxSubBstSize = 0;
        if (leftInfo != null) {
            maxSubBstSize = leftInfo.maxSubBstSize;
        }
        if (rightInfo != null) {
            maxSubBstSize = Math.max(maxSubBstSize, rightInfo.maxSubBstSize);
        }

        isBST = false;
        if (
            //左树整体是搜索二叉树
                (leftInfo == null || leftInfo.isBST)
                        &&
                        (rightInfo == null || rightInfo.isBST)
                        &&
                        (leftInfo == null || leftInfo.max < X.value)
                        &&
                        (rightInfo == null || rightInfo.min > X.value)
        ) {
            maxSubBstSize = (leftInfo == null ? 0 : leftInfo.maxSubBstSize)
                    + (rightInfo == null ? 0 : rightInfo.maxSubBstSize)
                    + 1;
            isBST = true;
        }
        return new Info(isBST, maxSubBstSize, min, max);

    }

}
