public class Main {

    public static void main(String[] args) {
        String txt = "AABAACAADAABAAABAABBABBBAABAAABAAAAAABBBBBBBAABAAAABAA";
        String pat = "AABA";
        //NaiveAlgorithm.search(txt, pat);
        char[] txt1 = "AABAACAADAABAAABAABBABBBAABAAABAAAAAABBBBBBBAABAAAABAA".toCharArray();
        char[] pat1 = "AABA".toCharArray();
        //GFG.search(pat1, txt1);
        KMPAlgorithm.KMPSearch(pat, txt);
    }
}
