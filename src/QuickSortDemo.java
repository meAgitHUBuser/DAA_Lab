import java.util.Scanner;

public class QuickSortDemo {

     public static void main(String[] args) {
          
          Scanner sc = new Scanner(System.in);

          System.out.println("Enter the size of the array: ");
          int n = sc.nextInt();

          int[] arr = new int[n];
          System.out.println("Enter the elements of the array: ");
          for(int i = 0; i < n; i++){
               arr[i] = sc.nextInt();
          }

          quickSort(arr, 0, arr.length - 1);

          System.out.println("Sorted array: ");
          for(int i = 0; i < arr.length; i++){
               System.out.print(arr[i] + " ");
          }

          sc.close();
     }

     private static void quickSort(int[] arr, int low, int high) {
          
          if(low<high){
               int pi = partition(arr, low, high);
               quickSort(arr, low, pi-1);
               quickSort(arr, pi+1, high);
          }
     }

     private static int partition(int[] arr, int low, int high) {
          
          int pivot = arr[high];
          int i = low - 1;
          for(int j = low; j < high; j++){
               if(arr[j] < pivot){
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
               }
          }

          int temp = arr[i+1];
          arr[i+1] = arr[high];
          arr[high] = temp;
          return i+1;
     }
}
