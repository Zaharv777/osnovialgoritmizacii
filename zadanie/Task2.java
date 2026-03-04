import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел N: ");
        int N = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(scanner.nextInt());
        }

        // Сортировка по возрастанию
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        System.out.println("Вывод1 (по возрастанию):");
        for (int num : sorted) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Сортировка без повторений
        Set<Integer> uniqueSorted = new TreeSet<>(numbers);
        System.out.println("Вывод2 (по возрастанию без повторений):");
        for (int num : uniqueSorted) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}