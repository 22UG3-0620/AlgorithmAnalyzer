import java.util.*;

public class Bubble_Sort {

    public static void run() {
        int[] sizes = {100, 500, 1000};
        Random rand = new Random();

        System.out.println("\nAlgorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size, rand);

            long start = System.nanoTime();
            bubbleSort(arr);
            long end = System.nanoTime();

            System.out.printf("%-10d | %.4f%n", size, (end - start) / 1_000_000.0);
        }
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    static int[] generateArray(int size, Random rand) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(10000);
        return arr;
    }
}
