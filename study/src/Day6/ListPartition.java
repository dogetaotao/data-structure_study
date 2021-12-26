package Day6;


import org.w3c.dom.Node;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 14:55 2021/12/24
 * @ Description：链表的荷兰国旗问题
 * @ Modified By：
 * @Version: $
 */
public class ListPartition {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    //method1:利用数组的荷兰国旗方法
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index < big) {
            if (nodeArr[index].value == pivot) {
                index++;
            } else if (nodeArr[index].value < pivot) {
                swap(nodeArr, index++, ++small);
            } else if (nodeArr[index].value > pivot) {
                swap(nodeArr, index, --big);
            }
        }
    }

    public static void swap(Node[] arr, int i, int j) {
        Node a = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    //method2:空间复杂度为O(1)的方法
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                } else {
                    sT.next = head;
                }
                sT = head;
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                } else {
                    eT.next = head;
                }
                eT = head;
            } else {
                if (mH == null) {
                    mH = head;
                } else {
                    mT.next = head;
                }
                mT = head;
            }
            head = next;
        }
        //小于区域的尾巴连等于区域的头，等于区域的尾巴连大于区域的头
        if (sT != null) {
            sT.next = eH;
            //如果等于区域为空，则将小于区域的尾巴变为等于区域的尾巴
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);

    }

}
