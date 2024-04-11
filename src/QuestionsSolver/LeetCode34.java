package QuestionsSolver;

import java.util.Scanner;

// first and Last Occurance in Sorted Array
public class LeetCode34 {
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
        int[] arr = new int[]{first, last};
        for (int index = 0; index < arr.length; index++) {
            System.out.println(arr[index]);
        }

    }

//    public static int[] searchRange(int[] number, int target) {
//        int first = firstOccurance(number, target);
//        if (first == -1) return new int[]{-1, -1};
//        int last = lastOccurance(number, target);
//        return new int[]{first, last};
//
//    }

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
