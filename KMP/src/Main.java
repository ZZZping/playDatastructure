public class Main {

    public static void main(String[] args) {
        kmpStringMatcher kmpStringMatcher = new kmpStringMatcher();
        System.out.println(kmpStringMatcher.indexOf("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }
}
