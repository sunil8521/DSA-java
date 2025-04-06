public class ReverseArrayStack {
    int top = -1;
    int[] stack;
    int capacity;

    ReverseArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == capacity - 1;
    }

    void push(int item) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = item;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }
        return stack[top--];
    }

    int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }

    void print() {
        System.out.println();
        for (int i = 0; i <= top; i++) {
            System.out.print(" " + stack[i] + " ");
        }
        System.out.println();
    }

    // Insert at bottom using recursion
    void insertAtBottom(int item) {
        if (isEmpty()) {
            push(item);
        } else {
            int temp = pop();
            insertAtBottom(item);
            push(temp);
        }
    }

    // Reverse stack using recursion
    void reverse() {
        if (!isEmpty()) {
            int temp = pop();
            reverse();
            insertAtBottom(temp);
        }
    }

    public static void main(String[] args) {
        ReverseArrayStack s = new ReverseArrayStack(10);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        System.out.println("Original Stack:");
        s.print();

        s.reverse();

        System.out.println("Reversed Stack:");
        s.print();
    }
}
