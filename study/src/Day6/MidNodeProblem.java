package Day6;


import org.w3c.dom.Node;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 13:44 2021/12/24
 * @ Description：快慢指针问题
 * @ Modified By：
 * @Version: $
 */
public class MidNodeProblem {

    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    //输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if(head.next.next == null){
            return head;
        }
        //快慢指针
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if(head.next.next == null){
            return head;
        }
        //快慢指针
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入链表头节点，奇数长度返回中点的前一个，偶数长度返回上中点的前一个
    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if(head.next.next == null){
            return head;
        }
        //快慢指针
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入链表头节点，奇数长度返回中点的前一个，偶数长度返回下中点的前一个
    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if(head.next.next == null){
            return head;
        }
        //快慢指针
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
