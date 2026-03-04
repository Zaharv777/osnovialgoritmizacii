import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();
        // 10 песен (некоторые повторяются)
        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C");
        playlist.add("Song A");
        playlist.add("Song D");
        playlist.add("Song B");
        playlist.add("Song E");
        playlist.add("Song F");
        playlist.add("Song G");
        playlist.add("Song A");

        System.out.println("Исходный плейлист:");
        printPlaylist(playlist);

        // Подсчёт частоты
        Map<String, Integer> freq = new HashMap<>();
        for (String s : playlist) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        // Оставляем только уникальные (частота == 1)
        LinkedList<String> cleaned = new LinkedList<>();
        for (String s : playlist) {
            if (freq.get(s) == 1) {
                cleaned.add(s);
            }
        }
        playlist = cleaned;

        System.out.println("После удаления повторных (прослушанных >1 раза):");
        printPlaylist(playlist);
    }

    private static void printPlaylist(LinkedList<String> playlist) {
        int i = 1;
        for (String s : playlist) {
            System.out.println(i++ + ". " + s);
        }
        if (playlist.isEmpty()) System.out.println("Плейлист пуст.");
    }
}