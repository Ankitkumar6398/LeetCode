import java.util.Arrays;
import java.util.Scanner;

public class LeetCode1011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        int[] weight = new int[sizeOfArray];
        for (int index = 0; index < weight.length; index++) {
            weight[index] = scanner.nextInt();
        }
        int days = scanner.nextInt();
        System.out.println(shipWithinDays(weight, days));
    }

    public static int shipWithinDays(int[] weight, int days) {
        Arrays.sort(weight);
        int low = weight[weight.length - 1];
        int high = 0;
        for (int i = 0; i < weight.length; i++) {
            high += weight[i];
        }
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int numOfDays = counter(weight, mid);
            if (numOfDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int counter(int[] weight, int mid) {
        int day = 1;
        int sum = 0;
        for (int index = 0; index < weight.length; index++) {
            if (sum + weight[index] > mid) {
                day++;
                sum = weight[index];
            } else {
                sum += weight[index];
            }
        }
        return day;
    }
}
