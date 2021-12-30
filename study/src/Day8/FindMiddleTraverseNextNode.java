package Day8;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 16:57 2021/12/30
 * @ Description：一个有三个指针的二叉树，找到某节点中序遍历时下一个遍历到的节点
 * @ Modified By：
 * @Version: $
 */
public class FindMiddleTraverseNextNode {
    public static class Node {
        public int value;
        public Node header;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node findMiddleTraverseNextNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getMostLeft(node.left);
        } else { //如果此节点是某节点(r)左孩子的最右边的孩子，则返回r
            Node header = node.header;
            while (header != null && header.left != node) { //当前节点是其父亲的右节点
                node = header;
                header = node.header;
            }
            return header;
        }
    }

    public static Node getMostLeft(Node node) {
        if (node.left == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
