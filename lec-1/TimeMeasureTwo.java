public class TimeMeasureTwo {
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        findSum(10000000);
        long end = System.nanoTime();
        double timeTaken = (end - start) / 1e9;
        System.out.printf("findSum(int n) took %.6f seconds to execute\n", timeTaken);
    }
}
