import java.util.Scanner;

public class KnapsackGreedy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

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

        System.out.print("Enter the maximum capacity of the knapsack: ");
        int maxCapacity = scanner.nextInt();

        float[] ratios = new float[n];
        for (int i = 0; i < n; i++) {
            ratios[i] = (float) values[i] / weights[i];
        }

        float totalProfit = 0;
        int remainingCapacity = maxCapacity;

        while (remainingCapacity > 0) {
            float maxRatio = 0;
            int selectedItemIndex = -1;

            for (int i = 0; i < n; i++) {
                if (weights[i] > 0 && ratios[i] > maxRatio) {
                    maxRatio = ratios[i];
                    selectedItemIndex = i;
                }
            }

            if (selectedItemIndex == -1) {
                break;
            }

            if (weights[selectedItemIndex] <= remainingCapacity) {
                System.out.println("Item " + (selectedItemIndex + 1) + " added.");
                remainingCapacity -= weights[selectedItemIndex];
                totalProfit += values[selectedItemIndex];
                weights[selectedItemIndex] = 0; // Mark the item as used
            } else {
                System.out.println("Partial quantity of item " + (selectedItemIndex + 1) + " added.");
                totalProfit += remainingCapacity * ratios[selectedItemIndex];
                remainingCapacity = 0;
            }
        }

        System.out.println("Total profit: " + totalProfit);
        scanner.close();
    }
}
