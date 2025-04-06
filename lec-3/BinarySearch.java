import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];

        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        System.out.print("Enter the sorted elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();

        int low = 0, high = size - 1, mid, found = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == key) {
                found = mid;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (found == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at position: " + (found + 1));
        }
    }
}
