package Day6;

import java.util.Stack;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 14:07 2021/12/24
 * @ Description：判断一个链表是不是回文结构
 * @ Modified By：
 * @Version: $
 */
public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    //method1
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        //把链表元素加入栈中
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //将栈弹出元素和原链表元素比较，如果不相同则不是回文的
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //method2
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        Node help = null;
        while (fast != null) {
            help = fast.next;//记录下fast下一个位置
            fast.next = slow;//将fast节点处next反向
            slow = fast;//slow前进
            fast = help;//fast前进
        }//执行完成后，fast指向了null,slow来到了最后的节点的位置
        help = slow;//help保存最后一个节点
        fast = head;//fast返回到最初的头节点
        boolean res = true;
        while (slow != null && fast != null) {
            if (slow.value != fast.value) {
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        slow = help.next;//记录下链表倒数第二个节点
        help.next = null;//让链表最后一个节点的next指向null
        //把链表还原后再返回结果
        while (slow != null) {
            fast = slow.next;
            slow.next = help;
            help = slow;
            slow = fast;
        }
        return res;
    }
}
