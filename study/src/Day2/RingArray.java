package Day2;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 13:17 2021/12/17
 * @ Description：数组实现队列
 * @ Modified By：
 * @Version: $
 */
public class RingArray {

    public static class MyQueue {
        private int[] arr;
        private int pushi;//放入新元素的位置
        private int polli;//取出新元素的位置
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("栈满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("栈空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        //如果现在的下标是i，请返回下一个位置
        public int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }

    }

}
