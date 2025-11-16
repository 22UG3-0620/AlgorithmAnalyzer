import java.util.*;

public class Binary_Search {

    public static void run() {
        int[] sizes = {100, 500, 1000};
        Random rand = new Random();

        System.out.println("\nAlgorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size, rand);
            Arrays.sort(arr);
            int target = arr[rand.nextInt(size)];

            long start = System.nanoTime();
            Arrays.binarySearch(arr, target);
            long end = System.nanoTime();

            System.out.printf("%-10d | %.4f%n", size, (end - start) / 1_000_000.0);
        }
    }

    static int[] generateArray(int size, Random rand) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(10000);
        return arr;
    }
}
