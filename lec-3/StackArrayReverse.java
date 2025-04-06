import java.util.Stack;

public class StackArrayReverse {
    public static void reverseArrayUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int value : arr) {
            stack.push(value);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArrayUsingStack(arr);
        System.out.print("Reversed Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

