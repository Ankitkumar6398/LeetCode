// Count Number of Occurance using BinarySearch
import java.util.Scanner;
public class CountTheOccurance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] number = new int[size];
        for (int index = 0; index < number.length; index++) {
            number[index] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int first = firstOccurance(number, target);
        int last = lastOccurance(number, target);
        int count = last - first+1;
        System.out.println("count = " + count);


    }

    public static int firstOccurance(int[] number, int target) {
        int low = 0;
        int first = -1;
        int high = number.length - 1;
        while (low <= high) {
            int middleIndex = low + ((high - low) / 2);
            if (number[middleIndex] == target) {
                first = middleIndex;
                high = middleIndex - 1;
            } else if (number[middleIndex] < target) {
                low = middleIndex + 1;
            } else {
                high = middleIndex - 1;

            }
        }
        return first;
    }

    public static int lastOccurance(int[] number, int target) {
        int low = 0;
        int last = -1;
        int high = number.length - 1;
        while (low < high) {
            int middleIndex = low + ((high - low) / 2);
            if (number[middleIndex] == target) {
                last = middleIndex;
                low = middleIndex + 1;
            } else if (number[middleIndex] < target) {
                low = middleIndex + 1;
            } else {
                high = middleIndex - 1;

            }
        }
        return last;
    }
}
