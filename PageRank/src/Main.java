import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int nodes,i,j,cost;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Number of WebPages \n");
        nodes = in.nextInt();
        PageRank p = new PageRank();
        System.out.println("Enter the Adjacency Matrix with 1->PATH & 0->NO PATH Between two WebPages: \n");
        for(i=1;i<=nodes;i++) {
            for (j = 1; j <= nodes; j++) {
                p.path[i][j] = in.nextInt();
                if (j == i) {
                    p.path[i][j] = 0;
                }
            }
        }
        p.calc(nodes);
    }
}
