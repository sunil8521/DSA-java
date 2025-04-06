import java.util.Scanner;

public class SortedInsert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];

        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        System.out.print("Enter the sorted elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to insert: ");
        int elem = sc.nextInt();

        int i = size - 1;
        while (i >= 0 && arr[i] > elem) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = elem;
        size++;

        System.out.print("Array after insertion: ");
        for (i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
