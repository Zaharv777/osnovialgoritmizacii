import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        LinkedList<String> tasks = new LinkedList<>();
        tasks.add("Купить продукты");
        tasks.add("Сделать домашнее задание");
        tasks.add("Позвонить маме");
        tasks.add("Помыть посуду");
        tasks.add("Прочитать книгу");

        System.out.println("Текущие задачи:");
        printTasks(tasks);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Добавить задачу в конец: ");
        tasks.addLast(scanner.nextLine());
        System.out.println("После добавления:");
        printTasks(tasks);

        System.out.print("Вывести первые N задач. N = ");
        int N = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Первые " + N + " задач:");
        for (int i = 0; i < Math.min(N, tasks.size()); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        System.out.print("Введите задачу для удаления (название или номер): ");
        String input = scanner.nextLine();
        boolean removed = tasks.remove(input);
        if (!removed) {
            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < tasks.size()) {
                    tasks.remove(index);
                    removed = true;
                }
            } catch (NumberFormatException ignored) {}
        }
        System.out.println(removed ? "Задача удалена." : "Задача не найдена.");
        System.out.println("Обновлённый список:");
        printTasks(tasks);
    }

    private static void printTasks(LinkedList<String> tasks) {
        int i = 1;
        for (String t : tasks) {
            System.out.println(i++ + ". " + t);
        }
        if (tasks.isEmpty()) System.out.println("Список пуст.");
    }
}