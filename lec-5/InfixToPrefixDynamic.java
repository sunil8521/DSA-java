import java.util.*;

public class InfixToPrefixDynamic {

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
        return Character.isLetter(ch);
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

    static void getPostfix(char[] expression) {
        int len = expression.length;
        char[] result = new char[len];
        int j = 0;

        for (int i = 0; i < len; i++) {
            char ch = expression[i];

            if (isOperand(ch)) {
                result[j++] = ch;
            } else if (ch == '(') {
                push(ch);
            } else if (ch == ')') {
                while (!isEmpty() && peek() != '(') {
                    result[j++] = pop();
                }
                if (!isEmpty() && peek() != '(') return;
                else pop();
            } else {
                while (!isEmpty() && precedence(ch) <= precedence(peek())) {
                    result[j++] = pop();
                }
                push(ch);
            }
        }

        while (!isEmpty()) {
            result[j++] = pop();
        }

        for (int i = 0; i < j; i++) {
            expression[i] = result[i];
        }
        expression[j] = '\0';
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

    static void swapBrackets(char[] exp) {
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '(') exp[i] = ')';
            else if (exp[i] == ')') exp[i] = '(';
        }
    }

    static void infixToPrefix(char[] expression) {
        reverse(expression);
        swapBrackets(expression);
        getPostfix(expression);
        reverse(expression);
    }

    public static void main(String[] args) {
        String expr = "((a/b)+c)-(d+(e*f))";
        System.out.println("The infix is: " + expr);

        char[] expression = Arrays.copyOf(expr.toCharArray(), MAX);

        infixToPrefix(expression);

        StringBuilder result = new StringBuilder();
        for (char c : expression) {
            if (c == '\0') break;
            result.append(c);
        }

        System.out.println("The prefix is: " + result);
    }
}
