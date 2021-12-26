package Day2;


/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 23:06 2021/12/16
 * @ Description：双向链表实现栈
 * @ Modified By：
 * @Version: $
 */
public class DoubleEndsQueueToStackAndQueue {

    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data) {
            value = data;
        }
    }

    public static class DoubleEndsQueue<T> {
        public Node<T> head;//头部元素
        public Node<T> tail;//尾部元素

        //从顶部压入元素
        public void addFromHead(T value) {
            Node<T> cur = new Node<T>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        //从底部压入元素
        public void addFromBottom(T value) {
            Node<T> cur = new Node<T>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        //从头部取出元素
        public T popFromHead() {
            if (head == null) {
                return null;
            }

            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }

        //从底部取出元素
//        public T popFromBottom() {
//            if (head == null) {
//                return null;
//            }
//
//            Node<T> cur = tail;
//            if (head == tail) {
//                head = null;
//                tail = null;
//            } else {
//                tail = tail.last;
//                cur.last = null;
//                tail.next = null;
//            }
//            return cur.value;
//        }

        //判断是否为空
        public boolean isEmpty(){
            return head == null;
        }
    }

    //实现栈
    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack(){
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value){
            queue.addFromHead(value);
        }

        public T pop(){
            return queue.popFromHead();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }

    }

    //实现队列
    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue(){
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value){
            queue.addFromBottom(value);
        }

        public T pop(){
            return queue.popFromHead();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }

    }
}
