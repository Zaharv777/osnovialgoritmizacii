import java.util.LinkedList;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 23; i++) {
            list.add(random.nextInt(201) - 100); // [-100, 100]
        }
        System.out.println("Исходный список: " + list);

        boolean hasNegative = list.stream().anyMatch(n -> n < 0);

        if (hasNegative) {
            list.removeIf(n -> n < 0);
            System.out.println("После удаления отрицательных: " + list);
        } else {
            if (list.size() >= 10) {
                int removed = list.remove(9); // 10-й элемент (индекс 9)
                System.out.println("Отрицательных нет, удалён 10-й элемент: " + removed);
                System.out.println("После удаления: " + list);
            } else {
                System.out.println("В списке меньше 10 элементов.");
            }
        }
    }
}