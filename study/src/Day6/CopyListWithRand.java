package Day6;

import java.util.HashMap;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 19:03 2021/12/24
 * @ Description：克隆一个特殊的链表
 * @ Modified By：
 * @Version: $
 */
public class CopyListWithRand {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    //method1: 利用哈希表
    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            //cur 老
            //map.get(cur) 新
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //method2:
    public static Node copyListWithRand2(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //1 -> 2 -> 3  ===>   1 -> 1' -> 2 -> 2' -> 3 ...
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while (cur != null){
            curCopy = cur.next;
            next = cur.next.next;
            curCopy.rand = cur.rand != null? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;//1' 头节点
        cur = head;
        //把1' 2' 3'单独拎出来相连
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null? next.next : null;
            cur = next;
        }
        return res;
    }
}
