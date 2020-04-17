import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Main {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        pra1_2_1.drawbox(1, 1);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        double min = pra1_2_1.findminist(pra1_2_1.drawpoint(N));
    }
}
