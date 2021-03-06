import java.util.ArrayList;

public class Main {
    public static double testSet(Set<String> set, String filename){
        long startTime = System.nanoTime();
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        //FileOperation.readFile("pride-and-prejudice.txt",words);
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word: words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "pride-and-prejudice.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set " + time1 + "s");
        System.out.println();
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("LinkedList Set " + time2 + " s");
        AVLSet<String> avlSet = new AVLSet<>();
        double time3 = testSet(avlSet, filename);
        System.out.println("AVLSet " + time3 + " s");
    }
}
