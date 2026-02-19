package zadanie2;

import java.util.Scanner;

public class ReverseWord {
    public ReverseWord() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String word = scanner.nextLine();
        String reversed = (new StringBuilder(word)).reverse().toString();
        System.out.println("Результат: " + reversed);
    }
}
