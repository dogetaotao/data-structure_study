package Day6;


import org.w3c.dom.Node;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 21:40 2021/12/24
 * @ Description：有两个链表，不一定是否有环或者是否相交，找到两个链表第一个相交节点，如果没有，返回nul
 * @ Modified By：
 * @Version: $
 */
public class GetIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return TwoLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    //情况1：1.两个链表均没有环(可能有相交点)、
    //情况2.一个有环一个无环(必定没有相交点)、
    //情况3.均有环(可能有相交点,入环节点不一定是一个)

    //如果两个链表均没有环，找到两个链表相交的最初点
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head1 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;//谁长，cur1变成谁的头
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node TwoLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        //如果入环点一样
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1.next != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop2) {
                n--;
                cur2 = cur2.next;
            }
            if (cur1 != cur2) {
                return null;
            }

            cur1 = n > 0 ? head1 : head2;//谁长，cur1变成谁的头
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;//loop1和loop2都是相交的节点
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }


    //找到链表第一个入环节点，如果无环返回null
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;//慢指针
        Node n2 = head.next.next;//快指针
        while (n1 != n2) {
            //如果快指针能走到结束，必然无环
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; //n1、n2相遇后，n2回到起点并每次跳一个节点，下次相遇时必定在入环处
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


}
