import java.util.Scanner;

public class InsertInUnsortedArray {
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

        arr[size] = elem;
        size++;

        System.out.print("Array after insertion: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
