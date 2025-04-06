import java.util.Stack;

public class ReverseArrayUsingStack {

    static void reverseArray(int[] arr, int size) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size; i++) {
            stack.push(arr[i]);
        }

        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int size = arr.length;

        reverseArray(arr, size);

        System.out.print("Reversed Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
