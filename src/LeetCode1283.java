import java.util.Arrays;
import java.util.Scanner;



public class LeetCode1283 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = scanner.nextInt();
        }
        int thresHold = scanner.nextInt();
        System.out.println(smallestDivisor(arr ,thresHold));
    }
    public static int smallestDivisor(int[] arr ,int thresHold){
        Arrays.sort(arr);
        int maxOfArray = arr[arr.length-1];
        for (int i = 1; i <= maxOfArray; i++) {
            int sum = 0;
            for (int index = 0; index < arr.length; index++) {
                sum += (int) Math.ceil((double) arr[index] /i);
            }
            if(sum<=thresHold){
                return i;

            }
        }
        return -1;
    }
}
