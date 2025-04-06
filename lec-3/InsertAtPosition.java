import java.util.Scanner;

public class InsertAtPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];

        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        System.out.print("Enter the elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to insert: ");
        int elem = sc.nextInt();

        System.out.print("Enter the position (1-based index): ");
        int pos = sc.nextInt();

        for (int i = size; i >= pos; i--) {
            arr[i] = arr[i - 1];
        }

        arr[pos - 1] = elem;
        size++;

        System.out.print("Array after insertion: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
