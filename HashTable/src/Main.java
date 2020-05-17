import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pride and prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            Collections.sort(words);
            //Test BST
            long startTime = System.nanoTime();

            BSTMap<String, Integer> bstMap = new BSTMap<>();
            for (String word : words) {
                if (bstMap.contains(word)) {
                    bstMap.set(word, bstMap.get(word + 1));
                } else {
                    bstMap.add(word, 1);
                }
            }
            for (String word : words) {
                bstMap.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST " + time + " s");
            //Test AVL
            startTime = System.nanoTime();
            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.contains(word)) {
                    avlTree.set(word, avlTree.get(word + 1));
                } else {
                    avlTree.add(word, 1);
                }
            }
            for (String word : words) {
                avlTree.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL " + time + " s");

            //test RBTree
            startTime = System.nanoTime();
            RBTree<String, Integer> rbTree = new RBTree<>();
            for (String word : words) {
                if (rbTree.contains(word)) {
                    rbTree.set(word, rbTree.get(word + 1));
                } else {
                    rbTree.add(word, 1);
                }
            }
            for (String word : words) {
                rbTree.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree " + time + " s");

            //test HashTable
            startTime = System.nanoTime();
            HashTable<String, Integer> hashTable = new HashTable<>();
            for (String word : words) {
                if (hashTable.contains(word)) {
                    hashTable.set(word, hashTable.get(word + 1));
                } else {
                    hashTable.add(word, 1);
                }
            }
            for (String word : words) {
                hashTable.contains(word);
            }

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable " + time + " s");
        }
    }
}
