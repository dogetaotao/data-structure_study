package Day2;


/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 19:43 2021/12/16
 * @ Description：删除链表上指定值的元素
 * @ Modified By：
 * @Version: $
 */
public class RemoveValue {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static Node removeValue(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        // head来到第一个不需要删除的位置
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
