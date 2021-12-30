package Day8;

import Day7.SerializedBinaryTree;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 16:21 2021/12/30
 * @ Description：打印整棵二叉树
 * @ Modified By：
 * @Version: $
 */
public class PrintBinaryTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree");
        printInOrder(head, 0, "H", 17);
    }

    //len为默认每个字符串长度为17，防止上下对不齐
    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(111111);
        Node left1 = new Node(71761111);
        Node right1 = new Node(121313);
        Node left2 = new Node(13341);
        Node right2 = new Node(6571);
        Node left3 = new Node(99991);
        Node right3 = new Node(1788779);
        Node left4 = new Node(111111);
        Node right4 = new Node(4556511);
        Node left5 = new Node(7781);
        Node right5 = new Node(19);
        Node left6 = new Node(9911);
        Node right6 = new Node(5);

        head.right = right1;
        head.left = left1;
        left1.left = left3;
        left1.right = right3;
        left2.left = left4;
        right2.right = right4;
        left3.left = left5;
        left3.right = right5;
        left4.left = left6;
        left4.right = right6;

        printTree(head);
    }


}
