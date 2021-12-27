package Day7;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 20:51 2021/12/26
 * @ Description：按层依次遍历二叉树
 * @ Modified By：
 * @Version: $
 */
public class BinaryTreeTraverseByLine {

    public static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }

    //按层依次打印(不区分每层)
    public static void binaryTreeTraverseByLine1(Node head) {
        if (head == null) {
            return;
        }
        //利用队列先进先出的特性
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value + "  ");
            if (cur.left != null) {
                queue.add(head.left);
            }
            if (cur.right != null) {
                queue.add(head.right);
            }
        }
    }

    //得到二叉树最大层的宽度
    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        //key 在哪一层
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;//当前统计的那一层宽度
        int curLevelNodes = 0;//当前层宽度目前是多少
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);//目标所在层数
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            if (curNodeLevel == curLevel) {
                curLevelNodes++;//当前层目前宽度加一
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;//当前层加一
                curLevelNodes = 1;//当前层宽度设置为1
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }


    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        //通过记录下一层的最右节点，找到遍历时何时对应节点何时到达当前层最后
        Node curEnd = head;//当前层，最右节点
        Node nextEnd = null;//下一层最右节点
        int max = 0;
        int curLevelNodes = 0;//当前层节点数
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left != null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if(cur == curEnd){
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
}
