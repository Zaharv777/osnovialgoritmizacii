import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expr = scanner.nextLine();
        double result = evaluate(expr);
        System.out.println("Результат: " + result);
    }

    private static double evaluate(String expr) {
        expr = expr.replaceAll("\\s+", "");
        LinkedList<Double> values = new LinkedList<>();   // стек чисел
        LinkedList<Character> ops = new LinkedList<>();  // стек операторов

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    sb.append(expr.charAt(i));
                    i++;
                }
                i--;
                values.push(Double.parseDouble(sb.toString()));
            } else if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop(); // убираем '('
            } else if (isOperator(ch)) {
                while (!ops.isEmpty() && precedence(ch, ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(ch);
            }
        }

        while (!ops.isEmpty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // true, если приоритет op1 не выше op2
    private static boolean precedence(char op1, char op2) {
        if (op2 == '(') return false;
        return (op1 != '*' && op1 != '/') || (op2 == '+' || op2 == '-');
    }

    private static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Деление на ноль");
                return a / b;
            default: return 0;
        }
    }
}