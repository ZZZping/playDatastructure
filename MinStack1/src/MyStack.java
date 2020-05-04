import java.util.Stack;

public class MyStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int NewNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(NewNum);
        } else if (NewNum <= this.getmin()) {
            this.stackMin.push(NewNum);
        }
        this.stackData.push(NewNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new IllegalArgumentException("StackData is empty!");
        }
        if (this.stackData.pop() == this.getmin()) {
            this.stackMin.pop();
        }
        return this.stackData.pop();
    }

    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new IllegalArgumentException("Stack is null");
        }
        return this.stackMin.peek();
    }
}
