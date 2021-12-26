package Day2;

import org.w3c.dom.Node;

import javax.crypto.interfaces.PBEKey;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 19:24 2021/12/16
 * @ Description：反转链表
 * @ Modified By：
 * @Version: $
 */
public class ReverseLinkedList {

    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            value = data;
        }
    }
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data){
            value = data;
        }
    }

    //单向链表反转链表
    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //双向链表反转链表
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
