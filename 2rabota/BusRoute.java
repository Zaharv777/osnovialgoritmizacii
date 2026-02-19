package zadanie2;

import java.util.Scanner;

// Добавляем класс StopNode
class StopNode {
    String cityName;
    int travelTimeFromPrev;  // время от предыдущей остановки
    StopNode next;

    public StopNode(String cityName, int travelTimeFromPrev) {
        this.cityName = cityName;
        this.travelTimeFromPrev = travelTimeFromPrev;
        this.next = null;
    }
}

public class BusRoute {
    private StopNode head;
    private StopNode tail;

    public BusRoute() {
        this.head = null;
        this.tail = null;
    }

    public void addStop(String cityName, int travelTimeFromPrev) {
        StopNode newNode = new StopNode(cityName, travelTimeFromPrev);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public boolean insertAfter(String targetCity, String newCity,
                               int travelTimeFromPrev, int travelTimeToNext) {
        for (StopNode current = this.head; current != null; current = current.next) {
            if (current.cityName.equals(targetCity)) {
                StopNode newNode = new StopNode(newCity, travelTimeFromPrev);

                // Сохраняем ссылку на следующий узел
                StopNode nextNode = current.next;

                // Вставляем новый узел
                newNode.next = nextNode;
                current.next = newNode;

                // Если вставляем после последнего элемента, обновляем tail
                if (current == this.tail) {
                    this.tail = newNode;
                }

                // Обновляем время для следующего узла (если он есть)
                if (nextNode != null) {
                    nextNode.travelTimeFromPrev = travelTimeToNext;
                }

                return true;
            }
        }
        return false;
    }

    public int totalTravelTime() {
        int total = 0;
        for (StopNode current = this.head; current != null; current = current.next) {
            total += current.travelTimeFromPrev;
        }
        return total;
    }

    public void printRoute() {
        StopNode current = this.head;
        int cumulativeTime = 0;
        int stopNumber = 1;

        System.out.println("\n=== Маршрут автобуса ===");

        while (current != null) {
            cumulativeTime += current.travelTimeFromPrev;
            System.out.printf("%d. %s (прибытие через %d мин.)\n",
                    stopNumber++, current.cityName, cumulativeTime);
            current = current.next;
        }

        System.out.println("========================");
        System.out.println("Общее время в пути: " + cumulativeTime + " мин.");
        System.out.println("Общее время в пути: " + (cumulativeTime / 60) +
                " ч " + (cumulativeTime % 60) + " мин.");
    }

    public static void main(String[] args) {
        BusRoute route = new BusRoute();

        // Добавляем начальные остановки
        route.addStop("Москва", 0);
        route.addStop("Владимир", 180);
        route.addStop("Нижний Новгород", 240);

        System.out.println("Исходный маршрут:");
        route.printRoute();

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведите город, после которого вставить: ");
        String target = scanner.nextLine();

        System.out.print("Введите название нового города: ");
        String newCity = scanner.nextLine();

        System.out.print("Введите время от предыдущего города до нового (мин.): ");
        int timeFromPrev = scanner.nextInt();

        System.out.print("Введите время от нового города до следующего (мин.): ");
        int timeToNext = scanner.nextInt();

        if (route.insertAfter(target, newCity, timeFromPrev, timeToNext)) {
            System.out.println("\n✓ Остановка добавлена успешно!");
        } else {
            System.out.println("\n✗ Город не найден!");
        }

        System.out.println("\nОбновлённый маршрут:");
        route.printRoute();

        scanner.close();
    }
}