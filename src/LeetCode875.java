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
        minEatingSpeed(piles, h);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles[piles.length - 1];
        System.out.println("n = " + n);

        for (int index = 1; index <= n; index++) {
            int reqTime = fun(piles, index);
            if (reqTime <= h) {
                System.out.println(index);
                return index;
            }


        }

        return 0;
    }

    public static int fun(int[] piles, int hour) {
        int totalTime = 0;
        System.out.println("hour " + hour);
        for (int index = 0; index < piles.length; index++) {
            totalTime += Math.ceil((double) piles[index] / (double) hour);
        }
        return totalTime;
    }
}
