public class ReverseArrayTwoPointer {
    
    static void reverseArray(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
    }

    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        printArray(arr, arr.length);
        reverseArray(arr, 0, arr.length - 1);
        System.out.println("Reversed array is");
        printArray(arr, arr.length);
    }
}
