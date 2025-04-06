import java.util.Scanner;

public class TimeMeasure {
    public static void fun() {
        System.out.println("fun() starts");
        System.out.println("Press enter to stop fun");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("fun() ends");
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        fun();
        long endTime = System.nanoTime();
        double timeTaken = (endTime - startTime) / 1e9;
        System.out.printf("fun() took %.6f seconds to execute\n", timeTaken);
    }
}
