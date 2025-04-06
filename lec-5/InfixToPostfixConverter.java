import java.util.Scanner;

class Stack {
    int top;
    int maxSize;
    char[] array;

    Stack(int max) {
        this.maxSize = max;
        this.top = -1;
        this.array = new char[max];
    }

    boolean isFull() {
        if (top == maxSize - 1) {
            System.out.println("Will not be able to push, maxSize reached");
        }
        return top == maxSize - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(char item) {
        if (isFull()) return;
        array[++top] = item;
    }

    char pop() {
        if (isEmpty()) return Character.MIN_VALUE;
        return array[top--];
    }

    char peek() {
        if (isEmpty()) return Character.MIN_VALUE;
        return array[top];
    }
}

public class InfixToPostfixConverter {

    static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static void convertInfixToPostfix(char[] expression) {
        int n = expression.length;
        Stack stack = new Stack(n);
        int j = -1;

        for (int i = 0; i < n; i++) {
            char ch = expression[i];

            if (isOperand(ch)) {
                expression[++j] = ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    expression[++j] = stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    System.out.println("Invalid expression");
                    return;
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    expression[++j] = stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            expression[++j] = stack.pop();
        }

        expression[++j] = '\0';
        for (int i = 0; i < j; i++) {
            System.out.print(expression[i]);
        }
    }

    public static void main(String[] args) {
        char[] expression = "((a+(b*c))-d)".toCharArray();
        convertInfixToPostfix(expression);
    }
}
