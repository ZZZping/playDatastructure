
public class Main {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        MyStack2 myStack2 = new MyStack2();
        int[] num ={3, 4, 5, 1, 2, 1};
        for (int i : num) {
            myStack.push(i);
            myStack2.push(i);
        }
        System.out.println(myStack.getmin());
        System.out.println(myStack2.getMin());
    }
}
