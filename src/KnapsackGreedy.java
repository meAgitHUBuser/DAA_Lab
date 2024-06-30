import java.util.Scanner;

public class KnapsackGreedy {
     public static void main(String[] args) {
          int n, maxCapacity;
          float totalProfit = 0;

          Scanner scanner = new Scanner(System.in);

          System.out.println("Enter the number of items: ");
          n = scanner.nextInt();

          int[] weights = new int[n];
          int[] values = new int[n];

          System.out.println("Enter the weights of the items: ");
          for (int i = 0; i < n; i++) {
               weights[i] = scanner.nextInt();
          }

          System.out.println("Enter the values of the items: ");
          for (int i = 0; i < n; i++) {
               values[i] = scanner.nextInt();
          }

          System.out.println("Enter the maximum capacity of the knapsack: ");
          maxCapacity = scanner.nextInt();

          int remainingCapacity = maxCapacity;

          float[][] itemRatio = new float[n][2];
          for (int i = 0; i < n; i++) {
               itemRatio[i][0] = (float) values[i] / weights[i];
               itemRatio[i][1] = i;
          }

          while (remainingCapacity > 0) {
               float maxRatio = 0;
               int selectedItemIndex = -1;

               for (int i = 0; i < n; i++) {
                    if (itemRatio[i][0] > maxRatio && values[(int) itemRatio[i][1]] > 0) {
                         maxRatio = itemRatio[i][0];
                         selectedItemIndex = (int) itemRatio[i][1];
                    }
               }

               if (selectedItemIndex == -1) {
                    break;
               }

               if (weights[selectedItemIndex] > remainingCapacity) {
                    System.out.println(
                              "Quantity of item number: " + (selectedItemIndex + 1) + " added is " + remainingCapacity);
                    totalProfit += remainingCapacity * maxRatio;
                    remainingCapacity = 0;
               } else {
                    System.out.println("Quantity of item number: " + (selectedItemIndex + 1) + " added is "
                              + weights[selectedItemIndex]);
                    remainingCapacity -= weights[selectedItemIndex];
                    totalProfit += values[selectedItemIndex];
                    values[selectedItemIndex] = 0;
               }
          }

          System.out.println("The total profit is " + totalProfit);
          scanner.close();
     }
}
