import java.util.Scanner;
import java.io.*;

public class ReadWeightedGraphUtil {
    private Scanner scanner;

    public ReadWeightedGraphUtil(WeightGraph<Double> graph, String filename) {
        readFile(filename);

        // Ϊ��չʾ������չʾ˼·�������ﲻ���쳣��⣬�� V �� E ���Ϸ�ʱ���׳��쳣
        int V = scanner.nextInt(); // ������
       int E = scanner.nextInt();// ����

        System.out.println(V + " " + E);

        // �ӵ� 2 �п�ʼ���ı���Ϣ������ʾ��
        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt(); // �ݲ���� v �� w �ĺϷ���
            int w = scanner.nextInt();
            Double weight = scanner.nextDouble();
            // ��һ���ߵ���Ϣ��ȡ�����Ժ󣬾�Ҫ��ӵ�ͼ��
            graph.addEdge(new Edge<Double>(v,w,weight));
        }

    }

    private void readFile(String filename) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis));
                // scanner.useLocale(Locale.ENGLISH);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        // ϡ��ͼ
        SpareWeightedGraph<Double> graph1 = new SpareWeightedGraph<>(8, false);
        String filename = "tinyEWD.txt";
        new ReadWeightedGraphUtil(graph1, filename);
        System.out.println("ϡ��ͼ��ʾ");
        graph1.show();

        System.out.println();
        // ����ͼ
        DenseWeightedGraph<Double> graph2 = new DenseWeightedGraph<>(8, false);
        new ReadWeightedGraphUtil(graph2, filename);
        System.out.println("����ͼ��ʾ");
        graph2.show();
    }

}
