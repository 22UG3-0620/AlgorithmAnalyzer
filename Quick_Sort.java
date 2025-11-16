import java.util.*;

public class Quick_Sort {

    public static void run() {
        int[] sizes = {100, 500, 1000};
        Random rand = new Random();

        System.out.println("\nAlgorithm: Quick Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size, rand);

            long start = System.nanoTime();
            quickSort(arr, 0, arr.length - 1);
            long end = System.nanoTime();

            System.out.printf("%-10d | %.4f%n", size, (end - start) / 1_000_000.0);
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static int[] generateArray(int size, Random rand) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(10000);
        return arr;
    }
}
