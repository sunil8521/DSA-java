import java.util.Scanner;

public class SortedDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];

        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        System.out.print("Enter the sorted elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to delete: ");
        int elem = sc.nextInt();

        int pos = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == elem) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Element not found");
        } else {
            for (int i = pos; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;

            System.out.print("Array after deletion: ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
