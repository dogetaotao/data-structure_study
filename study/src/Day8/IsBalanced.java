package Day8;

import java.awt.*;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 18:36 2021/12/30
 * @ Description：检查一个二叉树是否是平衡树(每个节点的子项高度差不超过1)
 * @ Modified By：
 * @Version: $
 */
//        1)假设以X节点为头，假设可以向X左数和右数要任何信息
//
//        2)在上一步的假设下，讨论以X为头节点的树，得到答案的可能性
//
//        3)列出所有可能性后，确定向左树和右树要什么样的信息
//
//        4)把左数信息和右树信息求全集，就是任意一棵子树都需要返回的信息S
//
//        5)递归函数都返回S，每一棵子树都这样要求
//
//        6)写代码，在代码中考虑如何把左树信息和右树信息整合出整棵树的信息
public class IsBalanced {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBalanced1(Node head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head, ans);
        return ans[0];
    }

    public static int process1(Node head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return -1;
        }
        int leftHeight = process1(head.left, ans);
        int rightHeight = process1(head.right, ans);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;

    }

    //左右要求一样
    //假设有方法可以得到某节点是否是平衡的和高度
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean b, int h) {
            isBalanced = b;
            height = h;
        }
    }

    public static boolean isBalanced2(Node head) {
        return process2(head).isBalanced;
    }

    public static Info process2(Node x) {
        if (x == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process2(x.left);
        Info rightInfo = process2(x.right);

        boolean isBalanced = true;

        int height = Math.max(leftInfo.height, rightInfo.height + 1);
        if (!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }

        return new Info(isBalanced, height);

    }
}
