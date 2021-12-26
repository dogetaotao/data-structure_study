package Day7;

import java.net.Socket;
import java.util.Stack;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 14:24 2021/12/26
 * @ Description：二叉树的先序、中序、后序遍历
 * @ Modified By：
 * @Version: $
 */
public class BinaryTreeTraverse {
    public static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }

    //递归方式实现
    public static void binaryTreeTraverse1(Node head) {
        if (head == null) {
            return;
        }
//        System.out.print(head.value + " ");  先序遍历
        binaryTreeTraverse1(head.left);
//        System.out.print(head.value + " ");  中序遍历
        binaryTreeTraverse1(head.right);
//        System.out.print(head.value + " ");  后序遍历
    }

    //栈方式实现
    //先序遍历
    public static void binaryTreeFirstTraverse2(Node head) {
        System.out.println("先序遍历：");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + "  ");
                //先压右，在压左，这样保证输出时先左后右
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    //中序遍历
    public static void binaryTreeMiddleTraverse2(Node head) {
        System.out.println("中序遍历：");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                //先把左边界全压进栈
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + "  ");
                    head = head.right;
                }
            }
        }
    }

    //后序遍历：
    //method1 用两个栈实现
    public static void binaryTreeLastTraverse2(Node head) {
        System.out.println("后序遍历：");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.add(head);
            stack2.add(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                //先压右，在压左，这样保证输出时先左后右
                if (head.left != null) {
                    stack1.push(head.left);
                    stack2.add(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                    stack2.add(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + "  ");
            }
        }
    }

    //method2 用一个栈实现
    public static void binaryTreeLastTraverse3(Node head) {
        System.out.println("后序遍历：");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                //检查左孩子有没有处理，如果没有则先处理左孩子
                if (c.left != null && head != c.left && head != c.right) {
                    stack.push(c.left);
                }
                //如果左孩子被处理了，右孩子没处理，则处理右孩子
                else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                }
                //如果左右孩子都处理了，则打印并把表示上个打印元素的head指针指向c
                else {
                    System.out.println(stack.pop().value + "  ");
                    head = c;
                }
            }
        }
    }

}
