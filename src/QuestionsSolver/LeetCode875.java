package QuestionsSolver;

import java.util.Arrays;
import java.util.Scanner;


public class LeetCode875 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] piles = new int[size];
        for (int index = 0; index < piles.length; index++) {
            piles[index] = scanner.nextInt();
        }
        int h = scanner.nextInt();
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles[piles.length - 1];
// using brute Force Approach

//        for (int index = 1; index <= n; index++) {
//            int reqTime = fun(piles, index);
//            if (reqTime <= h) {
//                return index;
//            }
//
//
//        }

        // Using Binary Search


        int firstIndex = 1;
        int lastIndex = n;
        while (firstIndex <= lastIndex) {
            int mid = firstIndex + ((lastIndex - firstIndex) / 2);
            int reqTime = fun(piles, mid);
            if (reqTime <= h) {
                lastIndex = mid - 1;

            } else {
                firstIndex = mid + 1;
            }
        }

        return firstIndex;
    }

    public static int fun(int[] piles, int hour) {
        int totalTime = 0;

        for (int index = 0; index < piles.length; index++) {
            totalTime += (int) Math.ceil((double) piles[index] / (double) hour);
        }
        return totalTime;
    }
}
