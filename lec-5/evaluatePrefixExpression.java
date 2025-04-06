import java.util.*;

public class evaluatePrefixExpression {
    static boolean isOperand(char c) {
        return c >= '0' && c <= '9';
    }

    static double evaluatePrefix(String exprsn) {
        Stack<Double> stack = new Stack<>();

        for (int j = exprsn.length() - 1; j >= 0; j--) {
            char ch = exprsn.charAt(j);

            if (isOperand(ch)) {
                stack.push((double)(ch - '0'));
            } else {
                double o1 = stack.pop();
                double o2 = stack.pop();

                switch (ch) {
                    case '+': stack.push(o1 + o2); break;
                    case '-': stack.push(o1 - o2); break;
                    case '*': stack.push(o1 * o2); break;
                    case '/': stack.push(o1 / o2); break;
                }
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String exprsn = "+9*26";
        System.out.println(evaluatePrefix(exprsn));
    }
}
