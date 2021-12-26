package Day2;

import java.util.Stack;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 15:37 2021/12/19
 * @ Description：实现一个特殊的栈，在基本功能的基础上，实现返回栈中最小元素的功能
 * @ Modified By：
 * @Version: $
 */
public class GetMinStack {

    public static class MyStack {
        private Stack<Integer> normalStack;
        private Stack<Integer> minStack;

        public MyStack() {
            normalStack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int i) {
            if (this.normalStack.isEmpty()) {
                this.minStack.push(i);
            } else if (i < this.getMin()) {
                this.minStack.push(i);
            } else {
                int min = this.minStack.peek();
                this.minStack.push(min);
            }
            this.normalStack.push(i);
        }

        public int pop() {
            if (this.normalStack.isEmpty()) {
                throw new RuntimeException("栈为空，无法取出元素");
            } else {
                this.minStack.pop();
                return this.normalStack.pop();
            }
        }

        public int getMin() {
            if (this.normalStack.isEmpty()) {
                throw new RuntimeException("栈为空，无法取出元素");
            } else {
                return this.normalStack.peek();
            }
        }
    }
}
