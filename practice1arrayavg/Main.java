import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] numbers = new int[]{485, 5, 231, 35, 74};
        System.out.println("Текущий массив: " + Arrays.toString(numbers));     
        
        int avg_sum = 0;
        for (int i = 0; i < numbers.length; i++) {
              avg_sum += numbers[i];
        }
        double average = (double) avg_sum / numbers.length;
        System.out.println("Среднее арифметическое: " + average);
        
        
        
        int min = numbers[0];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Минимальный элемент: " + min);
        
        int minindex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minindex]) {
                minindex = i;
            }
        }
        
        int[] numbersmin = new int[numbers.length - 1];
        
        for (int i = 0; i < minindex; i++) {
          numbersmin[i] = numbers[i];
        }
        
        for (int i = minindex + 1; i < numbers.length; i++) {
          numbersmin[i-1] = numbers[i];
        }
        System.out.println("Массив без минимального элемента: " + Arrays.toString(numbersmin));
        
        int max = numbers[0];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Максимальный элемент: " + max);
        
        int maxindex = 0;
        for (int i = 1; i < numbers.length; i++) {
          if (numbers[i] > numbers[maxindex]) {
            maxindex = i;
          }
        }
        
        numbers[maxindex] = 0;
        System.out.println("Массив с заменой максимального элемента на 0: " + Arrays.toString(numbers));
        
    }
}