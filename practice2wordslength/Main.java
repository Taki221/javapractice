import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<String> words = new ArrayList<>();
        words.add("Яблоко");
        words.add("Помидор");
        words.add("Бургер");
        words.add("Солнце");
        words.add("Пляж");

        System.out.println("Изначальный массив: " + words);

        int shortestIndex = findShortest(words);
        int longestIndex = findLongest(words);

        swap(words, shortestIndex, longestIndex);

        System.out.println("Измененный массив: " + words);
    }

    public static int findShortest(ArrayList<String> list) {
        int minIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() < list.get(minIndex).length()) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findLongest(ArrayList<String> list) {
        int maxIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > list.get(maxIndex).length()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void swap(ArrayList<String> list, int shortest, int longest) {
        String temp = list.get(shortest);
        list.set(shortest, list.get(longest));
        list.set(longest, temp);

    }
}
