package Day2;

import java.util.Stack;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 16:16 2021/12/19
 * @ Description：用两个栈实现队列
 * @ Modified By：
 * @Version: $
 */
public class TwoStacksImplementQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksImplementQueue() {
        stackPop = new Stack<Integer>();
        stackPush = new Stack<Integer>();
    }

    //push栈导入pop栈，这样可以
    private void pushToPop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
        pushToPop();
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }
}
