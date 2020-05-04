import java.util.Stack;

public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
            this.stackMin.push(newNum);
        } else {
            //newNum >= this.geuMin()
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new IllegalArgumentException("StackData is empty!");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    /**
     * 返回StackMin栈顶元素
     * @return 返回最小元素
     */
    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new IllegalArgumentException("StackMin is empty!");
        }
        return this.stackMin.peek();
    }
}
