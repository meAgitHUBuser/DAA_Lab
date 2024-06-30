import java.util.Scanner;

public class KnapsackDP {

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapSack(int maxWeight, int weights[], int values[], int n) {
        int[][] dpTable = new int[n + 1][maxWeight + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (i == 0 || j == 0) {
                    dpTable[i][j] = 0;
                }
                else if (weights[i - 1] <= j) {
                    dpTable[i][j] = max(values[i - 1] + dpTable[i - 1][j - weights[i - 1]], dpTable[i - 1][j]);
                }
                else {
                    dpTable[i][j] = dpTable[i - 1][j];
                }
            }
        }
        return dpTable[n][maxWeight];
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of items: ");
        int n = scanner.nextInt();

        System.out.println("Enter the weights of the items: ");
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.println("Enter the values of the items: ");
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.println("Enter the maximum capacity of the knapsack: ");
        int maxWeight = scanner.nextInt();

        System.out.println("The maximum value that can be put in a knapsack of capacity " + maxWeight + " is: " +
                knapSack(maxWeight, weights, values, n));

        scanner.close();
    }
}
