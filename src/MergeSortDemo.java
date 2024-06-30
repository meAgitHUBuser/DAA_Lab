import java.util.Random;
import java.util.Scanner;

public class MergeSortDemo {
    
    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] b = new int[arr.length];
        int i = low, j = mid + 1, k = low;
        
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                b[k++] = arr[i++];
            } else {
                b[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            b[k++] = arr[i++];
        }
        
        while (j <= high) {
            b[k++] = arr[j++];
        }
        
        for (int a = low; a <= high; a++) {
            arr[a] = b[a];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        Random rand = new Random();
        
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(50);
        }

        System.out.println("Unsorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        long start = System.nanoTime();
        mergeSort(arr, 0, n - 1);
        long end = System.nanoTime();
        
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        System.out.println("Time taken: " + (end - start) + " nanoseconds");

        sc.close();
    }
}
