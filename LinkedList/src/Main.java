public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 857);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        for (int i = 4; i > 0; i --) {
            linkedList.removeLast();
            System.out.println(linkedList);
            i --;
        }
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
