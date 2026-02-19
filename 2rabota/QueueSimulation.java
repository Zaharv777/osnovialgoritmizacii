package zadanie2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class QueueSimulation {
    private static final int CASH_COUNT = 3;
    private static List<Queue<Integer>> queues = new ArrayList();
    private static Random random = new Random();

    public QueueSimulation() {
    }

    public static void main(String[] args) {
        for(int i = 0; i < 3; ++i) {
            queues.add(new LinkedList());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Управление: + (добавить покупателя), t (такт времени), q (выход)");

        while(true) {
            printQueues();
            System.out.print("Команда: ");
            switch (scanner.nextLine().trim()) {
                case "+":
                    addCustomer();
                    break;
                case "t":
                    timeTick();
                    break;
                case "q":
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неизвестная команда. Используйте +, t, q.");
            }
        }
    }

    private static void addCustomer() {
        int serviceTime = 1 + random.nextInt(5);
        int shortestIndex = 0;
        int minSize = ((Queue)queues.get(0)).size();

        for(int i = 1; i < 3; ++i) {
            if (((Queue)queues.get(i)).size() < minSize) {
                minSize = ((Queue)queues.get(i)).size();
                shortestIndex = i;
            }
        }

        ((Queue)queues.get(shortestIndex)).add(serviceTime);
        System.out.printf("Покупатель с временем %d встал в кассу %d%n", serviceTime, shortestIndex + 1);
    }

    private static void timeTick() {
        for(int i = 0; i < 3; ++i) {
            Queue<Integer> q = (Queue)queues.get(i);
            if (!q.isEmpty()) {
                int remaining = (Integer)q.peek() - 1;
                if (remaining <= 0) {
                    q.poll();
                    System.out.printf("Касса %d обслужила покупателя.%n", i + 1);
                } else {
                    q.poll();
                    q.add(remaining);
                }
            }
        }

    }

    private static void printQueues() {
        System.out.println("\n--- Состояние очередей ---");

        for(int i = 0; i < 3; ++i) {
            System.out.print("Касса " + (i + 1) + ": ");
            Iterator var1 = ((Queue)queues.get(i)).iterator();

            while(var1.hasNext()) {
                int time = (Integer)var1.next();
                System.out.print("" + time + " ");
            }

            System.out.println();
        }

        System.out.println("---------------------------\n");
    }
}