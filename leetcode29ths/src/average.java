public class average {
    public double average(int[] salary, int salarySize) {
        int min = salary[0];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < salarySize; i ++) {
            if (salary[i] < min) min = salary[i];
            if (salary[i] > max) max = salary[i];
            sum += salary[i];
        }
        return (sum - min - max) / (salarySize - 2.0);
    }

    public  void main(String[] args) {
        int[] s = {4000, 3000, 2000, 1000};
        System.out.println(average(s, s.length));
    }
}
