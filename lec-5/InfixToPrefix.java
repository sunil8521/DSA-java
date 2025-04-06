import java.util.*;

public class InfixToPrefix {

    static final int MAX = 100;
    static int top = -1;
    static char[] stack = new char[MAX];

    static boolean isFull() {
        return top == MAX - 1;
    }

    static boolean isEmpty() {
        return top == -1;
    }

    static void push(char item) {
        if (isFull()) return;
        stack[++top] = item;
    }

    static char pop() {
        if (isEmpty()) return (char) Integer.MIN_VALUE;
        return stack[top--];
    }

    static char peek() {
        if (isEmpty()) return (char) Integer.MIN_VALUE;
        return stack[top];
    }

    static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    static void getPostfix(char[] expression) {
        int j = -1;
        char[] result = new char[expression.length];

        for (int i = 0; i < expression.length; i++) {
            char ch = expression[i];

            if (isOperand(ch)) {
                result[++j] = ch;
            } else if (ch == '(') {
                push(ch);
            } else if (ch == ')') {
                while (!isEmpty() && peek() != '(') {
                    result[++j] = pop();
                }
                if (!isEmpty() && peek() == '(') {
                    pop();
                }
            } else {
                while (!isEmpty() && precedence(ch) <= precedence(peek())) {
                    result[++j] = pop();
                }
                push(ch);
            }
        }

        while (!isEmpty()) {
            result[++j] = pop();
        }

        result[++j] = '\0';
        System.arraycopy(result, 0, expression, 0, j);
    }

    static void reverse(char[] exp) {
        int i = 0, j = exp.length - 1;
        while (i < j) {
            char temp = exp[i];
            exp[i] = exp[j];
            exp[j] = temp;
            i++;
            j--;
        }
    }

    static void changeBrackets(char[] exp) {
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '(') {
                exp[i] = ')';
            } else if (exp[i] == ')') {
                exp[i] = '(';
            }
        }
    }

    static void infixToPrefix(char[] exp) {
        reverse(exp);
        changeBrackets(exp);
        top = -1;
        getPostfix(exp);
        reverse(exp);
    }

    public static void main(String[] args) {
        String input = "((a/b)+c)-(d+(e*f))";
        System.out.println("The infix is: " + input);
        char[] expression = input.toCharArray();
        infixToPrefix(expression);
        System.out.print("The prefix is: ");
        for (char c : expression) {
            if (c == '\0') break;
            System.out.print(c);
        }
    }
}
