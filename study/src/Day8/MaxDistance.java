package Day8;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 20:54 2021/12/30
 * @ Description：寻找一个二叉树两个节点间最大距离
 * @ Modified By：
 * @Version: $
 */
public class MaxDistance {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //假设有方法可以得到某节点最大距离和高度
    public static class Info {
        public int MaxDistance;
        public int height;

        public Info(int dis, int h) {
            MaxDistance = dis;
            height = h;
        }
    }

    public static Info process(Node X) {
        if (X == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(
                Math.max(leftInfo.MaxDistance, rightInfo.MaxDistance),//不经过X点的X节点下的节点最长距离
                leftInfo.height + rightInfo.height + 1//经过X点的X节点下的节点最长距离
        );
        return new Info(maxDistance, height);
    }
}
