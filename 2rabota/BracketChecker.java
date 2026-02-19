package zadanie2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;

public class BracketChecker {
    public BracketChecker() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку со скобками {} []: ");
        String input = scanner.nextLine();
        if (isValidBrackets(input)) {
            System.out.println("все верно");
        } else {
            System.out.println("есть ошибки");
        }

    }

    public static boolean isValidBrackets(String s) {
        Deque<Character> stack = new ArrayDeque();
        Map<Character, Character> pairs = Map.of('{', '}', '[', ']');
        char[] var3 = s.toCharArray();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            char ch = var3[var5];
            if (pairs.containsKey(ch)) {
                stack.push(ch);
            } else if (pairs.containsValue(ch) && (stack.isEmpty() || (Character)pairs.get(stack.pop()) != ch)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
